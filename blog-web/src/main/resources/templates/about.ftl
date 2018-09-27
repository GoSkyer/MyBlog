<!DOCTYPE html>
<html>
<head>
    <title>Goskyer | 关于我们</title>

    <!-- meta -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- css -->
    <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="/public/css/bootstrap.css">
    <link rel="stylesheet" href="/public/css/pace.css">
    <link rel="stylesheet" href="/public/css/custom.css">

    <!-- js -->
    <script src="/public/js/jquery-3.3.1.min.js"></script>
    <script src="/public/js/bootstrap.min.js"></script>
    <script src="/public/js/pace.min.js"></script>
    <script src="/public/js/modernizr.custom.js"></script>

</head>

<body>

<#include "common/navigation.ftl">

<div class="content-body">
    <div class="container">

        <div class="row">

            <main class="col-md-12">

                <h1 class="page-title">关于我们</h1>

                <article class="post">

                    <div class="entry-content clearfix" style="text-align: center">

                        <figure class="img-responsive-center">
                        <#--<img class="img-responsive" src="img/me.jpg" alt="CaptainGalaxy">-->
                        </figure>

                        <p>这里目前是放了一些自己写的博客，未来会添加一些功能，希望这里能成为一个让人喜欢的地方。</p>

                        <p>代码要一行行的写，故事要一行行的想。</p>

                        <div class="height-40px"></div>

                    </div>

                </article>

            </main>

        </div>

        <div class="row">
            <main class="col-md-12">
                <h1 class="page-title">联系我们</h1>
                <article class="post">
                    <div class="entry-content clearfix">
                        <form class="contact-form" id="contactForm">
                            <div class="row">
                                <div class="col-md-6 col-md-offset-3">
                                    <input type="text" name="name" placeholder="名字" id="name">
                                    <input type="email" name="email" placeholder="邮箱" id="email">
                                    <input type="text" name="title" placeholder="标题" id="title">
                                    <textarea name="content" rows="7" placeholder="填写内容不能为空..." id="content"></textarea>
                                </div>
                            </div>    <!-- row -->
                        </form>

                        <button class="btn-send btn-5 btn-5b ion-ios-paperplane" id="contactSubmit">
                            <span>发送</span>
                        </button>

                    </div>
                </article>
            </main>
        </div>

    </div>
</div>

<#include "common/bottom.ftl">

</body>

<script type="text/javascript">

    $("#contactSubmit").click(function () {

        var data = $("#contactForm").serialize();

        console.log(data);

        if (data.content == null) {
            alert("内容不能为空");
            return;
        }

        $.post("/about/contact/add", data, function (result) {
            alert("发送成功");
        });

    });

</script>

</html>
