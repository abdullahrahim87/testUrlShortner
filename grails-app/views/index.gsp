<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to URL Shortner</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">URL Shortener</h1>
        <p class="lead text-muted">Simplify your links</p>


        <form id="shortenForm">
            <div align="center" class="col-lg-12 center-block form-group">

                <input type="url" id="url" class="url-field form-control" placeholder="Your Original URL here" id="url" />

            </div>
            <button type="button" id="shortenUrl" class="btn btn-default">Shorten URL</button>

        </form>
        <div class="success-shorten"></div>
        <form class="expand-form" id="expandUrlForm">
            <div align="center" class="col-lg-12 center-block form-group">

                <input type="url" id="shortUrl" class="url-field form-control" placeholder="Your Shortened URL here" />

            </div>
            <button type="button" id="expandUrl" class="btn btn-default">Expand URL</button>

        </form>
        <div class="success-expand"></div>
    </div>
</section>

</body>
</html>
