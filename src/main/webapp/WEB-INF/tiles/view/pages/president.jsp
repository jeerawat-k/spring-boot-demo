<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.4.1-1/js/bootstrap.min.js"></script>

</head>

<body>


<table class="table table-striped table-hover table-condensed table-bordered">
    <tr>
        <th><p><spring:message code="home.title"/></p></th>
        <th>Name</th>
    </tr>
    <tr>
        <td>xx</td>
        <td>xx</td>
    </tr>
</table>

<script>
    $(document).ready(function () {

    })

    // var data =  $.ajax({
    //     type: "GET",
    //     contentType: "application/json; charset=utf-8",
    //     dataType: "json",
    //     headers: {
    //         Accept: "application/json"
    //     },
    //     url: session.context + '/coGroup/findAllCoGroup',
    //     async: false
    // }).responseJSON;


    // $.ajax({
    //     type: "POST",
    //     contentType: "application/json; charset=utf-8",
    //     dataType: "json",
    //     headers: {
    //         Accept: "application/json"
    //     },
    //     url: "",
    //     data: JSON.stringify(data),
    //     complete: function (xhr) {
    //         if (xhr.readyState == 4) {
    //             if (xhr.getResponseHeader('statusValidate') == 0) {
    //
    //             } else {
    //
    //                 var msgError = xhr.getResponseHeader('errorMsg');
    //
    //             }
    //         }
    //
    //     },
    //     async: false
    // });

</script>

</body>

</html>
