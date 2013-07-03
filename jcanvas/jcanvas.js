
var log_bar_height = 20;
var log_text_bottom = 3;
var FLASH_CHARS = ["春", "夏", "秋", "冬", "筒", "条", "万", "梅", "兰", "竹", "菊", "琴", "棋", "书", "画","一","二","三","四","五","六","七","八","九","十","零","年","月","日","时","分","秒"];
//[" ", "!", "\"", "#", "$", "%", "&", "'", "(", ")",
//"*", "+", ",", "-", ".", "/", "0", "1", "2", "3",
//"4", "5", "6", "7", "8", "9", ":", ";", "<", "=",
//">", "?", "@", "A", "B", "C", "D", "E", "F", "G",
//"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
//"R", "S", "T", "U", "V", "W", "X", "Y", "Z", "[",
//"\\", "]", "^", "_", "`", "a", "b", "c", "d", "e",
//"f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
//"p", "q", "r", "s", "t", "u", "v", "w", "x", "y",
//"z", "{", "|", "}", "~", 
//"春", "夏", "秋", "冬", "筒", "条", "万", "梅", "兰", "竹", "菊", "琴", "棋", "书", "画"，"一"，"二","三","四","五","六","七","八","九","十","零","年","月","日","时","分","秒"];
//var Logger; 

// ----------------- Abstract Shape Object -----------------
function Shape() {
}

Shape.prototype = {
    x:0,
    y:0,
    isFill: true,
    isStroke: true,
    fillStyle: "Black",
    strokeStyle: "#22AA22",
    label:''
}

// ----------------- PieChart -----------------
PieChart.prototype = Shape.prototype;
function PieChart(x, y, percent, radius) {
    this.percent = percent;
    this.x = x;
    this.y = y;
    this.radius = radius;
    this.startAngle = 0;
    this.endAngle = 2 * Math.PI * percent;
    this.direction = true;
}

PieChart.prototype.setPercent = function (p) {
    this.percent = p;
    this.endAngle = 2 * Math.PI * this.percent;
}

PieChart.prototype.isMouseOver = function (mousePos) {
    return (mousePos.x > (this.x - this.radius) && mousePos.x < (this.x + this.radius))
           && (mousePos.y > (this.y - this.radius) && mousePos.y < (this.y + this.radius));
}

PieChart.prototype.draw=function(canvas){
    var ctx = canvas.getContext("2d");
    var gap = 3;
    if (Boolean(ctx)) {
        //avoid out of boundary
        //drawPieWithBorder(ctx,pieChart);
        ctx.beginPath();
        ctx.moveTo(this.x, this.y); //move to the center
        //log(canvas,pie.endAngle);
        ctx.arc(this.x, this.y, this.radius, this.startAngle, this.endAngle, this.direction);
        ctx.lineTo(this.x, this.y);

        if (this.isFill) {
            ctx.fillStyle = this.fillStyle;
            ctx.fill();
        }
        if (this.isStroke) {
            ctx.strokeStyle = this.strokeStyle
            ctx.stroke();
        }

        ctx.closePath();
        ctx.fillStyle = "blue";
        ctx.font = "12pt Helvetica";
        ctx.fillText(this.percent, this.x + gap + this.radius, this.y);
    }
}

// ----------------- Circle -----------------
Circle.prototype =inherit(Shape.prototype);
function Circle(x, y, radius, strokeStyle, fillStyle) {
    this.x = x;
    this.y = y;
    this.radius = radius;
    this.strokeStyle = strokeStyle;
    this.fillStyle = fillStyle;
}

Circle.prototype.draw = function (canvas) {

    var ctx = canvas.getContext("2d");
    var gap = 3;
    if (Boolean(ctx)) {
       
        ctx.beginPath();
        //ctx.moveTo(this.x, this.y); //move to the center
        //log(canvas,pie.endAngle);
        ctx.arc(this.x, this.y, this.radius, 0, 2 * Math.PI, this.direction);
        //ctx.lineTo(this.x, this.y);

        if (this.isFill) {
            ctx.fillStyle = this.fillStyle;
            ctx.fill();
        }
        if (this.isStroke) {
            ctx.strokeStyle = this.strokeStyle
            ctx.stroke();
        }

        ctx.closePath();

    }
}

// ----------------- CanvasManager -----------------
function CanvasManager(canvas) { this.canvas = canvas; }
CanvasManager.prototype = { }
//CanvasManager.prototype.drawPieChart = function (canvas, pie) {
//    pie.draw(canvas);
//}

CanvasManager.prototype.clearCanvas = function () {
   
    var ctx = this.canvas.getContext("2d");
    if (Boolean(ctx)) {
        ctx.clearRect(0, 0, this.canvas.width, this.canvas.height - log_bar_height);
    }
}

// ----------------- MouseMonitor -----------------
MouseMonitor.prototype = {}
function MouseMonitor(monitoredCavs, logger) {
    //alert(monitoredCavs);
    this.canvas = monitoredCavs;
    this.logger = logger;
    this.listeners = new Array();
}

MouseMonitor.prototype.monitorMousePos = function () {
    var mgr = this;
    canvas.addEventListener('mousemove',
        function (evt) {
            var mousePos = getMousePos(mgr.canvas, evt);
            var message = 'Mouse-Pos: ' + mousePos.x + ',' + mousePos.y;
            mgr.logger.writeLog(message);
        },
        false);
}

MouseMonitor.prototype.notifyListener = function (mousePos) {
    for (var i = 0; i < this.listeners.length; i++) {
        if (this.listeners[i].isMouseOver(mousePos)) {
            this.logger.writeLog( "Mouse over" + this.toString());
        }
    }
}

MouseMonitor.prototype.registerListener = function (obj) {
    this.listeners.push(obj);
    var mgr = this;
    canvas.addEventListener('mousemove',
      function (evt) {
          var mousePos = getMousePos(mgr.canvas, evt);
          mgr.notifyListener(mousePos);
      },
      false);
}

// ----------------- Logger -----------------
function Logger(canvas) {
    this.canvas = canvas;
}

Logger.prototype.writeLog = function (message) {
    var context = this.canvas.getContext('2d');
    var h = this.canvas.height;
    var w = this.canvas.width;
    context.clearRect(0, h - log_bar_height, w, log_bar_height);
    context.fillStyle = 'black';
    context.fillRect(0, h - log_bar_height, w, log_bar_height);
    context.fillStyle = "green";
    context.font = '16pt Calibri';
    context.fillText(message, 0, h);
}

// ----------------- utility funcs -----------------
function getMousePos(canvas, evt) {
    //alert(canvs);
    var rect = canvas.getBoundingClientRect();
    return {
        x: evt.clientX - rect.left,
        y: evt.clientY - rect.top
    };
}

function prepareAsciiChars() {
    var chars = new Array();
    for (var i = 0; i < 127; i++) chars[i] = String.fromCharCode(i);
    return chars;
}

// ----------------- OO basic concepts -----------------
function inherit(proto) {
    function F() { }
    F.prototype = proto
    return new F
}

// ----------------- FlashBoard -----------------

FlashBoard.prototype = inherit(Shape.prototype);
function FlashBoard(x, y, canvas, chars,fontSize,interval) {
    this.x = x;
    this.y = y;
    this.canvas = canvas;
    this.chars = chars;
    this.timer = null;
    this.count = 0;
    this.interval = interval;
    this.fillStyle = "#333333";
    this.bordFillStyle = "#dddddd";
    this.fontSize = fontSize;
    this.padding = 20;
    this.target = "-----";
}

FlashBoard.prototype.startFlash = function () {
    var count = this.chars.length;
    var _this = this;
    //alert(this.count);
    this.timer = setInterval(function () {
        //_this.count--;
        var i = Math.floor(Math.random() * count);
        var ctx = _this.canvas.getContext("2d");
        ctx.fillStyle = _this.bordFillStyle;
        var width = _this.fontSize + _this.padding * 2;
        ctx.fillRect(_this.x, _this.y, width, width);

        if (_this.isFill) {
            ctx.fillStyle = _this.fillStyle;
            ctx.fill();
        }
        ctx.font = _this.fontSize + "pt Helvetica";
        ctx.fillText(_this.chars[i], _this.x + _this.padding, _this.y + _this.fontSize + _this.padding);

        if (count == 0) {
            count = _this.chars.length;
        }

        if (_this.chars[i] == _this.target) {
            _this.stopFlash();
        }

    }, this.interval);
    return this.timer;
}

FlashBoard.prototype.stopFlash = function() {
    clearInterval(this.timer);
}

/// Flash stops when target is matched.
FlashBoard.prototype.setTarget = function (target) {
    this.target = target;
}

// ----------------- FlashBoardArray -----------------
// Control a group d FlashBoard
// n: number of flash board in a array
// style: 0-horizontal, 1-vertical, 2-circle
function FlashBoardArray(x, y, n, direction, interval, boardGap, canvas) {
    this.x = x;
    this.y = y;
    this.numberOfBoard = n;
    this.direction = direction;
    this.boards = new Array();
    this.flashTimers = new Array();
    this.interval=interval;
    this.boardGap=boardGap;
    this.boardLength=100;
    this.fontSize=50;
    this.canvas = canvas;
    this.target = null;
}

FlashBoardArray.prototype.buildBoards = function () {
    for (var i = 0; i < this.numberOfBoard; i++) {
        this.boards[i] = new FlashBoard(this.x + i * this.boardLength + this.boardGap * i, this.y, this.canvas, FLASH_CHARS, this.fontSize, this.interval);
    }
    //alert(this.boards[i]);
}

FlashBoardArray.prototype.startAll = function () {
    for (i = 0; i < this.numberOfBoard; i++) {
        this.startBoard(i);
    }
}

FlashBoardArray.prototype.startBoard = function (i) {
    //var _this = this;  
    this.flashTimers[i] = this.boards[i].startFlash();
}

FlashBoardArray.prototype.stopAll = function (i) {
    for (i = 0; i < this.numberOfBoard; i++) {
        this.stopBoard(i);
    }
}

FlashBoardArray.prototype.stopBoard = function (i) {
    clearInterval(this.flashTimers[i]);
}

// -- Flash stops when a char are matched
FlashBoardArray.prototype.setTarget = function (target) {
    for (i = 0; i < target.length && i < this.boards.length; i++ )  this.boards[i].setTarget (target[i]);
}

