<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="footer">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        var request = false;
        function getResult(myform){
            request = new XMLHttpRequest();
            request.open("POST",myform.attr("action"),true);
            request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            request.onreadystatechange = callback;
            request.send(myform.serialize());
        }
        function callback(){
            if(request.status == 200){
                $("#resultTest").text(request.responseText);
                showWindow();
                return false;
            }

        }
        $(document).on("submit", "#passwordform", function(event) {
            var $myform=$(this);
            getResult($myform);
            return false;
        });
        $(document).on("click",".close_window",function (){
            hideWindow();
        });
    </script>
</div>
</html>
