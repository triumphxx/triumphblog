<#--分页插件-->
<#macro pagaing pageData>
    <div style="text-align: center">
        <div id="datalist">
        </div>
        <script>
            layui.use('laypage', function(){
                var laypage = layui.laypage;
                laypage.render({
                    elem: 'datalist'
                    //总页数
                    ,count: ${pageData.total}
                    //每页条数
                    ,limit: ${pageData.size}
                    //当前页
                    ,curr: ${pageData.current}
                    ,jump: function(obj, first){
                        //首次不执行
                        if(!first){
                            location.href = "?pn=" + obj.curr;
                        }
                    }
                });
            });
        </script>
    </div>


</#macro>
<#macro plisting post>

    <li>
        <a href="/user/${post.authorId}" class="fly-avatar">
            <img src="${post.authorAvatar}" alt="${post.authorName}">
        </a>
        <h2>
            <a class="layui-badge">${post.categoryName}</a>
            <a href="/post/${post.id}">${post.title}</a>
        </h2>
        <div class="fly-list-info">
            <a href="/user/${post.authorId}" link>
                <cite>${post.authorName}</cite>
            </a>
            <span>${timeAgo(post.created)}</span>

            <span class="fly-list-nums">
                <i class="iconfont icon-pinglun1" title="回答"></i> ${post.commentCount}
              </span>
        </div>
        <div class="fly-list-badge">
            <#if post.recommend><span class="layui-badge layui-bg-red">精帖</span></#if>
            <#if post.level gt 0><span class="layui-badge layui-bg-black">置顶</span></#if>

        </div>
    </li>
</#macro>


<#--用户中心的左侧-->
<#macro centerLeft level>

    <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">
        <li class="layui-nav-item <#if level == 0> layui-this</#if>">
            <a href="/user/home">
                <i class="layui-icon">&#xe609;</i>
                我的主页
            </a>
        </li>
        <li class="layui-nav-item <#if level == 1> layui-this</#if>">
            <a href="/user/index">
                <i class="layui-icon">&#xe612;</i>
                用户中心
            </a>
        </li>
        <li class="layui-nav-item <#if level == 2> layui-this</#if>">
            <a href="/user/set">
                <i class="layui-icon">&#xe620;</i>
                基本设置
            </a>
        </li>
        <li class="layui-nav-item <#if level == 3> layui-this</#if>">
            <a href="/user/message">
                <i class="layui-icon">&#xe611;</i>
                我的消息
            </a>
        </li>
    </ul>
</#macro>