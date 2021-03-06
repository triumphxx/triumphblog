<#include "/include/macro.ftl"/>

<@layout "博客分类">
  <#include "/include/header-panel.ftl"/>
  <div class="layui-container">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-md8 content detail">
        <div class="fly-panel detail-box">
          <h1>${post.title}</h1>
          <div class="fly-detail-info">
            <span class="layui-badge layui-bg-green fly-detail-column">动态</span>

            <#if post.recommend> <span class="layui-badge layui-bg-black">置顶</span></#if>
            <#if post.level gt 0> <span class="layui-badge layui-bg-red">精帖</span></#if>

            <div class="fly-admin-box" data-id="123">
              <span class="layui-btn layui-btn-xs jie-admin" type="del">删除</span>
              <span class="layui-btn layui-btn-xs jie-admin" type="set" field="stick" rank="1">置顶</span>
              <span class="layui-btn layui-btn-xs jie-admin" type="set" field="status" rank="1">加精</span>
            </div>
            <span class="fly-list-nums">
            <a href="#comment"><i class="iconfont" title="回答">&#xe60c;</i> ${post.commentCount}</a>
            <i class="iconfont" title="人气">&#xe60b;</i>  ${post.viewCount}
          </span>
          </div>
          <div class="detail-about">
            <a class="fly-avatar" href="/user/${post.authorId}">
              <img src="${post.authorAvatar}" alt="${post.authorName}">
            </a>
            <div class="fly-detail-user">
              <a href="/user/${post.authorId}" class="fly-link">
                <cite>${post.authorName}</cite>
              </a>
              <span>${timeAgo(post.created)}</span>
            </div>
            <div class="detail-hits" id="lay_jieadmin" data-id=${post.id}>
              <span class="layui-btn layui-btn-xs jie-admin" type="edit"><a href="/post/edit?id=${post.id}">编辑此贴</a></span>
            </div>
          </div>
          <div class="detail-body photos">
            <p>
              ${post.content}
             </p>
            封面<hr>
            <p>
              <img src="../../res/images/fly.jpg" alt="fly社区">
            </p>
          </div>
        </div>

        <div class="fly-panel detail-box" id="flyreply">
          <fieldset class="layui-elem-field layui-field-title" style="text-align: center;">
            <legend>回帖</legend>
          </fieldset>

          <ul class="jieda" id="jieda">
            <#list pageData.records as comment>
                <li data-id="${comment.id}" class="jieda-daan">
                  <a name="item-${comment.id}"></a>
                  <div class="detail-about detail-about-reply">
                    <a class="fly-avatar" href="/user/${comment.authorId}">
                      <img src="${comment.authorAvatar}" alt="${comment.authorName}">
                    </a>
                    <div class="fly-detail-user">
                      <a href="/user/${comment.authorId}" class="fly-link">
                        <cite>${comment.authorName}</cite>
                      </a>
                      <#if comment.user_id=post.user_id>
                        <span>(楼主)</span>
                      </#if>
                    </div>

                    <div class="detail-hits">
                      <span>${timeAgo(comment.created)}</span>
                    </div>
                  </div>
                  <div class="detail-body jieda-body photos">
                    <p>${comment.content}</p>
                  </div>
                  <div class="jieda-reply">
                  <span class="jieda-zan zanok" type="zan">
                    <i class="iconfont icon-zan"></i>
                    <em>${comment.voteUp}</em>
                  </span>
                    <span type="reply">
                    <i class="iconfont icon-svgmoban53"></i>
                    回复
                  </span>
                    <div class="jieda-admin">
                      <span type="edit">编辑</span>
                      <span type="del">删除</span>
                    </div>
                  </div>
                </li>
            </#list>
          </ul>

          <div class="layui-form layui-form-pane">
            <form action="/jie/reply/" method="post">
              <div class="layui-form-item layui-form-text">
                <a name="comment"></a>
                <div class="layui-input-block">
                  <textarea id="l_content" name="content" required lay-verify="required" placeholder="请输入内容"  class="layui-textarea fly-editor" style="height: 150px;"></textarea>
                </div>
              </div>
              <div class="layui-form-item">
                <input type="hidden" name="jid" value="123">
                <button class="layui-btn" lay-filter="*" lay-submit>提交回复</button>
              </div>
            </form>
          </div>
        </div>
      </div>
      <#include "/include/right.ftl"/>
    </div>
  </div>
</@layout>






