<!DOCTYPE html>
<html>
<head>
    <title>Goskyer | 博文 - ${blog.title}</title>

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

            <main class="col-md-8">

                <article class="post post-1">

                    <header class="entry-header">
                        <h1 class="entry-title">${blog.title}</h1>
                        <div class="entry-meta">
                            <span class="post-category">
                                <a href="#">${blog.groupName}</a>
                            </span>
                            <span class="post-date">
                                <a href="#"><time class="entry-date">${blog.lastDate}</time></a>
                            </span>
                            <span class="post-author"><a href="#">${blog.userName}</a></span>
                            <span class="comments-link"><a href="#">${blog.commentNum} 评论</a></span>
                            <span class="views-count"><a href="#">${blog.readNum} 阅读</a></span>
                        </div>
                    </header>

                    <div class="entry-content clearfix" id="blogContent">${mdFile}</div>

                </article>

                <section class="comment-area" id="comment-area">

                    <hr>
                    <h3>发表评论</h3>

                    <form class="comment-form" id="commentForm">

                        <input type="hidden" id="blogId" name="blogId" value="${blog.id}">
                        <input type="hidden" id="blogName" name="blogName" value="${blog.title}">
                        <input type="hidden" id="userId" name="userId">

                        <div class="row">

                            <div class="col-md-4">
                                <label for="userName">名字：</label>
                                <input type="text" id="userName" name="userName" value="游客">
                            </div>

                            <div class="col-md-12">
                                <label for="content">评论：</label>
                                <textarea name="content" id="content" required></textarea>
                            </div>
                        </div>

                        <button type="button" class="comment-btn" id="commentSubmit">发表</button>

                    </form>

                    <div class="comment-list-panel">

                        <h3>评论列表，共 <span>${commentCount}</span> 条评论</h3>

                        <ul class="comment-list list-unstyled" id="commentList">

                            <#if commentList??>
                                <#list commentList as item>

                            <li class="comment-item">
                                <span class="nickname">${item.userName}</span>
                                <time class="submit-date">${item.createDate?datetime}</time>
                                <div class="text">
                                    ${item.content}
                                </div>
                            </li>
                                </#list>
                            </#if>

                        </ul>
                    </div>
                </section>
            </main>
            <aside class="col-md-4">
                <div class="widget widget-recent-posts">

                    <h3 class="widget-title">最新文章</h3>
                    <ul>
                        <#if newList??>
                            <#list newList as item>
                                 <li>
                                     <a href="/blog/${item.id}">${item.title}</a>
                                 </li>
                            </#list>
                        </#if>
                    </ul>
                </div>

            <#--<div class="widget widget-archives"></div>-->

                <div class="widget widget-category">
                    <h3 class="widget-title">分类</h3>
                    <ul>
                       <#if groupList??>
                            <#list groupList as item>
                                 <li>
                                     <a href="/content/index?g=${item['id']!""}">${item['name']!""} <span
                                             class="post-count">(${item['count']!"0"})</span></a>
                                 </li>
                            </#list>
                       </#if>
                    </ul>
                </div>

            </aside>
        </div>
    </div>
</div>

<#include "common/bottom.ftl">

</body>

<script type="text/javascript">

    $("#commentSubmit").click(function () {

        var data = $("#commentForm").serialize();

        console.log(data);

        if (data.content == null) {
            alert("评论内容不能为空");
            return;
        }

        $.post("/blog/comment/add", data, function (result) {

            alert("评论成功");

            getCommentList(result.blogId);
        });

    });

    function getCommentList(blogId) {
        $.get("/blog/comment/list", {"blogId": blogId}, function (result) {
            refreshCommentList(result);
        });
    }

    function refreshCommentList(list) {

        var comments = "";

        for (var i = 0; i < list.length; i++) {

            var item = list[i];
            comments += "<li class=\"comment-item\"><span class=\"nickname\">" + item.userName +
                    "</span><time class=\"submit-date\">" + formatDate("yyyy-MM-dd hh:mm:ss", item.createDate) +
                    "</time><div class=\"text\">" + item.content + "</div></li>"
        }

        $("#commentList").empty();
        $("#commentList").append(comments);
    }

    function formatDate(fmt, timestamp) {

        var date = new Date(timestamp);

        var o = {
            "M+": date.getMonth() + 1,
            "d+": date.getDate(),
            "h+": date.getHours(),
            "m+": date.getMinutes(),
            "s+": date.getSeconds(),
            "q+": Math.floor((date.getMonth() + 3) / 3),
            "S": date.getMilliseconds()
        };

        if (/(y+)/.test(fmt))
            fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));

        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));

        return fmt;
    }

</script>

</html>