<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Last opp fil | Databaser 1 & 2</title>
        <style>
            html *{
                box-sizing:border-box;
            }
            
            html, body{
                margin:0;
            }
            
            body, input, label{
                font-family:Arial;
                font-size: 1em;
                height: 100%;
            }
            
            .left{
                width:47.5%;
                padding-left:2.5%;
                display: inline-block;
                float: left;
            }
            
            .right{
                width:47.5%;
                padding-left:2.5%;
                display: inline-block;
                float: right;
                border-left: 1px solid #aaa;
                height: 100vh;
            }
            
            form label, form input{
                display: block;
                padding:0.5em;
            }
            form label{
                margin-top:1em;
                padding-left: 0.1em;
            }
            
            form input[type="submit"]{
                border:1px solid #26A65B;
                background: #26A65B;
                margin-top:2em;
                color:white;
            }
        </style>
    </head>
    <body>
        <section class="left">
            <h1>Legg til ny person med bilde</h1>
            <form action="" method="post">
                <label for="picture">Bilde:</label>
                    <input id="picture" name="picture" type="file" value=""/>
                <label for="first_name">Fornavn:</label>
                    <input id="first_name" name="first_name" type="text" value=""/>
                <label for="last_name">Etternavn:</label>
                    <input id="last_name" name="last_name" type="text" value=""/>
                <label for="address">Adresse:</label>
                    <input id="address" name="address" type="text" value=""/>
                <label for="zip_code">Postnummer:</label>
                    <input id="zip_code" name="zip_code" type="text" value=""/>
                <label for="city">Poststed:</label>
                    <input id="city" name="city" type="text" value=""/>
                <label for="phone_number">Telefonnummer:</label>
                    <input id="phone_number" name="phone_number" type="text" value=""/>
                
                <input type="submit" value="Legg til person" />
            </form>
        </section>
        <section class="right">
            <h1>Se personer fra databasen</h1>
        </section>
        <?php
        
        ?>
    </body>
</html>
