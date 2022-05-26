<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="popup_container" id = "testWindow">
    <div class="popup_content">
        <a href="#" class="close_window">&times;</a>
        <div class="result" id="resultTest"></div>
    </div>
</div>
<script>
    $(document).ready(function (){
        hideWindow();
    });
    function hideWindow(){
        $("#testWindow").hide();
    }
    function showWindow(){
        $("#testWindow").show();
    }
</script>
</html>
