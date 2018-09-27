<!DOCTYPE html>
<html>
<head>
    <title>Goskyer | 首页</title>

    <!-- meta -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- css -->
    <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="/public/css/bootstrap.css">
    <link rel="stylesheet" href="/public/css/pace.css">
    <link rel="stylesheet" href="/public/css/custom.css">

    <!-- js -->
    <script src="/public/js/jquery-2.1.3.min.js"></script>
    <script src="/public/js/bootstrap.min.js"></script>
    <script src="/public/js/pace.min.js"></script>
    <script src="/public/js/modernizr.custom.js"></script>

    <script src="/public/js/script.js"></script>

</head>

<body>

<!-- 手机菜单 -->
<div class="overlay overlay-hugeinc">
    <button type="button" class="overlay-close"><span class="ion-ios-close-empty"></span></button>
    <nav>
        <ul>
            <li><a href="${home}">首页</a></li>
            <li><a href="${content}">全部</a></li>
            <li><a href="${about}">关于</a></li>
        </ul>
    </nav>
</div>

<div class="container">

    <header id="site-header">

        <div class="row">

            <div class="col-md-4 col-sm-5 col-xs-8">
                <div class="logo">
                    <h1><a href="${home}"><b>Goskyer</b> 博客</a></h1>
                </div>
            </div>

            <div class="col-md-8 col-sm-7 col-xs-4">

                <nav class="main-nav" role="navigation">

                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle">
                            <span class="ion-navicon"></span>
                        </button>
                    </div>

                    <div class="collapse navbar-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li class="cl-effect-11"><a href="${home}" data-hover="首页">首页</a></li>
                            <li class="cl-effect-11"><a href="${content}" data-hover="全部">全部</a></li>
                            <li class="cl-effect-11"><a href="${about}" data-hover="关于我们">关于我们</a></li>
                        </ul>
                    </div>
                </nav>

            </div>

        </div>

    </header>

</div>