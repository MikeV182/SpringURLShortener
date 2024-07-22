<!DOCTYPE html>
<html lang="en">
  
<head>
    <meta charset="UTF-8">
    <title>shrtrl.ru</title>
</head>

<body>
<h1>URL SHORTENER</h1><hr>

Original URL: <a href="${resultPage.originURL}" target="_blank">${resultPage.originURL}</a>
<br><br>
Shorten URL: <input id="short_url" value="${resultPage.shortURL}" readonly></input>
<br><br>

<button onclick="Copy()">Copy Shortened Link</button>
<br><br>
<a href="/"><b>HOME PAGE</b></a>

<script>
    function Copy() {
        var copyText = document.getElementById("short_url");
        copyText.select();
        copyText.setSelectionRange(0, 99999); // For mobile devices
        navigator.clipboard.writeText(copyText.value);
        alert("Copied the Link: " + copyText.value);
    }
</script>

</body>
</html>