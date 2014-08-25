

function jqueryImport() {
    var script = document.createElement('script');
    script.src = 'http://code.jquery.com/jquery-2.1.1.js';
    document.getElementsByTagName('head')[0].appendChild(script);

    script.onload = function() {
        console.log("jquery is connected");
    };
}


var data = {
    oneFieldReady: false,
    oneNumber: "",
    twoNumber: "",
    operation: ""

};

//========================== class Calculator =================================
function Calc() {


    this.showThisInputFromTheControlPanel = function(i) {
        var regxSymbol = /[%|/|*|+|-|=|sqrt]/;
        var temp = $('#result').attr('value');

        if (temp == null 
                || i.match(regxSymbol) != null
                || data.oneNumber == '') {
            temp = '';
        }

        $('#result').attr('value', temp + i);

    };
    this.clearData = function() {
        data.oneFieldReady = false;
        data.oneNumber = '';
        data.twoNumber = '';
        data.operation = '';

    };

//method of sending request 
    this.post = function() {

        var result = JSON.stringify(data);
        console.log(result);

        $.ajax({
            type: 'POST',
            url: '/calculate/json',
            dataType: 'html',
            headers: {'Content-Type': 'application/json'},
            data: result,
            error: function(jqXHR, textStatus, errorThrown) {
                console.error("error : " + textStatus);
            },
            success: function(data, textStatus, jqXHR) {
                console.log("return  = " + data);
                $('#result').attr('value', data);
            }
        });
    };


//handle button presses to fill data
    this.processClickOnButton = function(i) {
        this.showThisInputFromTheControlPanel(i);
        //if the sign or point
        if ((data.oneNumber === "" && (i === "+" || i === "-"))
                || (data.oneNumber !== '' && i === '.' && !data.oneFieldReady)) {
            
            data.oneNumber += i;
            return;
        } else if ((data.operation !== "" && (data.twoNumber === "" && (i === "+" || i === "-")))
                || (data.twoNumber !== '' && i === '.')) {
            
            data.twoNumber += i;
            return;
        }

        //if  number
        if (!isNaN(parseInt(i, 10))) {
            if (!data.oneFieldReady) {
                data.oneNumber += i;
                return;
            } else {
                data.twoNumber += i;
                return;
            }
            //if operator  
        } else if (i !== '.') {
            if ((i === "=")) {
                this.post();
                this.clearData();
                return;
            }

            data.operation = i;
            data.oneFieldReady = true;
        }
    };

//generate calculator
    this.generationCalc = function() {

        $('body').append('<div id="calc"></div>');

        //the result field
        $('#calc').append('<div id="divResult"></div>');
        $('#divResult').append('<input type="text" id="result">');


        $('#calc').append('<div id="controlPanel"></div>');

        // bootons with numbers
        $('#controlPanel').append('<div id="numberButton"></div>');
        for (var i = 9; i >= 0; i--) {
            $('<button/>', {
                'id': 'bn' + i,
                'onclick': 'calc.processClickOnButton(' + '"' + i + '"' + ')',
                text: i
            }).appendTo('#numberButton');
        }

        //button operations on numbers
        $('#controlPanel').append('<div id="operation"></div>');
        var op = '% / * + - = . sqrt'.split(" ");
        for (var i = 0; i < op.length; i++) {
            $('<button/>', {
                'id': 'bn' + op[i],
                'onclick': 'calc.processClickOnButton(' + '"' + op[i] + '"' + ')',
                text: op[i]
            }).appendTo('#operation');
        }

    };
}


//---------------------- the order of execution of the script -----------------------------

jqueryImport();

var calc = new Calc();

window.onload = function() {
    calc.generationCalc();
};
