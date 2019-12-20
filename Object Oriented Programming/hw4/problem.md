# simple http server example
In this hw you can use  the simple http server which I uploaded on LMS.

1. when you enter http://ip_no:4321

the http server will send the following welcome.html file to the browser

<!DOCTYPE html>

<html>
<body>
<h2>Welcome </h2>
<p><a href="http://ip_no:8000/web/namesform.html">Clik to enter your name</a></p>
</body>
</html>
2. When you click “Clik to enter your name “ link on the browser window the following namesform.html file will be sent to the browser by http server.

<!DOCTYPE html>

<html>
<body>
<h2>HTML Forms</h2>
 <form method="post" action="/web/namesHandler">
  Name:<br>
  <input type="text" name="firstname" >
  <br>
  <br>
  <input type="submit" value="Submit">
</form> 
<p>pls  click the "Submit" button, the form-data will be sent .</p>
</body>
</html>
3. Then you enter a name and press submit button. The http server should extract the name received from the browser and compare it with names which are stored in a flat text file. If the received name is in the file then success.html page will be sent tho the browser otherwise failure.html page will be sent to the browser.

you can use the following link to write simple html pages

https://www.w3schools.com/html/html_forms.asp

for http protocol the page below may be useful

https://www.ntu.edu.sg/home/ehchua/programming/webprogramming/HTTP_Basics.html

note:
do NOT use

java.net.http.HttpRequest
java.net.http.HttpClient;
java.net.http.HttpResponse;
or similar libraries. (for example 
org.apache.http.HttpResponse)
