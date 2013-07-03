
function drawEye() {
    var canvas = document.getElementById("myCanvas");
    if (canvas.getContext) {
        // Draw some rectangles with different color values
        var ctx = canvas.getContext("2d");
        ctx.fillStyle = "red";
        ctx.fillRect(5, 5, 100, 100);
        ctx.fillStyle = "rgba(0,50,200,0.5)";
        ctx.fillRect(55, 55, 100, 100);
        ctx.fillStyle = "rgba(0,255,10,0.5)";
        ctx.fillRect(100, 100, 100, 100);
    }

}
