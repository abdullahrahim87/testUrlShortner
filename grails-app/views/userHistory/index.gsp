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

    </div>
</section>
<div class="container-fluid url-grid">
<g:if test="${userUrls}">
    <div class="row grid-header">
        <div class="col-sm-2">Short URL</div>
        <div class="col-sm-2">Long URL</div>
    </div>
    <g:each in="${userUrls}" var="url">
        <div class="row">
            <div class="col-sm-2">${url.shortUrl}</div>
            <div class="col-sm-2">${url.url}</div>
        </div>
    </g:each>
</g:if>
</div>
</body>
</html>
