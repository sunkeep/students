<?php

    $invalue = $_GET['input'];


    $res = preg_match ( $invalue, "/^https?:\/\/[a-zA-Z_-0-9\?\&\.]+$/" );
    if ($res === 1) {
        echo "URL OK: $invalue \n";
    } else {
        echo "failed validation";
    }
    
    // /^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$/


?>