/*
 Navicat Premium Data Transfer

 Source Server         : Gutaicheng
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 05/06/2022 18:07:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `permissions` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123', 1);
INSERT INTO `admin` VALUES (2, 'blog', '321', 2);

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `aid` int(0) NOT NULL AUTO_INCREMENT COMMENT '博文id',
  `uid` int(0) NOT NULL COMMENT '发表用户id',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '博文标题',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容html形式',
  `text` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容文本形式',
  `data` date NOT NULL COMMENT '发布日期',
  `state` int(0) NOT NULL COMMENT '状态 ',
  `views` int(0) NULL DEFAULT 0 COMMENT '浏览量',
  `comments` int(0) NULL DEFAULT 0 COMMENT '评论数',
  `cover` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面图片',
  PRIMARY KEY (`aid`) USING BTREE,
  INDEX `u-a`(`uid`) USING BTREE,
  CONSTRAINT `u-a` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (17, 1, '因发明 PowerShell 被微软降级？PowerShell 之父曾考虑出走', 'write.html:160 <blockquote style=\"font-size: 14px;\"><span style=\"color: rgb(85, 86, 102); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px; font-variant-ligatures: no-common-ligatures; background-color: rgb(238, 240, 244);\">整理 | 郑丽媛</span><br style=\"outline: 0px; overflow-wrap: break-word; color: rgb(85, 86, 102); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px; font-variant-ligatures: no-common-ligatures; background-color: rgb(238, 240, 244);\"><span style=\"color: rgb(85, 86, 102); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 16px; font-variant-ligatures: no-common-ligatures; background-color: rgb(238, 240, 244);\">出品 | CSDN（ID：CSDNnews）</span><br></blockquote><p>经常使用 Windows 操作系统的人，想必对 PowerShell 并不陌生。普通用户可能并不常用这一命令行工具，但对系统管理员而言，PowerShell 无疑是一个重要存在。<br><br>而本周，微软技术研究员、PowerShell 首席架构师 Jeffrey Snover 却在推特透露了一个信息：“当年因研究发明 PowerShell，我被微软降级了。”<br><br></p><p><img src=\"http://localhost:8080/Blog/upload/article/d8e2388bd9254595961de8efcb2be565.png\" style=\"max-width: 50%;\"><br></p><h2 style=\"margin-top: 8px; margin-bottom: 16px; font-weight: 600; line-height: 30px; outline: 0px; font-family: &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, SimHei, Arial, SimSun; font-size: 22px; color: rgb(79, 79, 79); overflow-wrap: break-word; font-variant-ligatures: no-common-ligatures;\">一、“勇气远比天才少”</h2><p style=\"margin-top: 0px; margin-bottom: 16px; line-height: 26px; outline: 0px; font-size: 16px; color: rgb(77, 77, 77); overflow: auto hidden; overflow-wrap: break-word; font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-variant-ligatures: no-common-ligatures;\">目前仍身处微软的 Jeffrey Snover 突然提起这件往事，并不是出于“翻旧账”，而是近期著名风险投资家 Peter Thiel 提出的一个看法引发了他的强烈认同：“勇气远比天才少。”</p><p style=\"margin-top: 0px; margin-bottom: 16px; line-height: 26px; text-align: center; outline: 0px; font-size: 16px; color: rgb(77, 77, 77); overflow: auto hidden; overflow-wrap: break-word; font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-variant-ligatures: no-common-ligatures;\"><img src=\"http://localhost:8080/Blog/upload/article/ee10ce3e9de64d75b1a5404207864e7c.png\" style=\"max-width: 100%;\"><br></p><p>Jeffrey Snover 感慨道：“太真实了。如今有许多问题仍未解决，因为解决它们需要勇气，而人们只专注于让老板认可地拍拍头。”<br><br>在 @m3sweatt 看来，Jeffrey Snover 所说的这种现象很好理解：因为在商业环境中，人们付出的勇气与回报很可能不成正比，甚至还会引发不可设想的后果，“尤其是当环境要求维持现状，你也没有强大的基础支持和自保措施时”。<br><br>不可否认，@m3sweatt 所剖析的原因正是当下大多数人的心理，Jeffrey Snover 对此调侃道：“勇气这个关键特征，要么出现在未来领导者身上，要么出现在（被解雇的）前员工身上。”<br><br>为证明这一说法并非毫无根据，Jeffrey Snover 公开了一个不为人知的秘密：他曾因“勇敢”在业余时间开发 PowerShell 的原型被微软降级。<br>————————————————<br>版权声明：本文为CSDN博主「CSDN资讯」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。<br>原文链接：https://blog.csdn.net/csdnnews/article/details/124813717</p>', '从入职以来，我一直在从事于开发Android版的Edge浏览器。这么长时间下来，我也慢慢从完全不知如何上手，提个PR都困难，到现在能够负责独立开发一个比较大的功能模块了。\r\n\r\n不得不说，Edge是我见过的最复杂的一个项目，我是真的很难想象一个浏览器工程可以庞大到如此地步。Chromium本身就已经是一个巨型工程了，而Edge又要在其基础之上加入许多微软定制的需求，那就肯定避免不了一通魔改，代码自然就变得更加复杂。', '2022-05-28', 1, 12, 0, 'http://localhost:8080/Blog/upload/article/d8e2388bd9254595961de8efcb2be565.png');
INSERT INTO `article` VALUES (19, 1, '我为Android版Microsoft Edge所带来的变化', '<p>掰手指数一数，我入职微软也已经有一年半的时间了。<br><br>从入职以来，我一直在从事于开发Android版的Edge浏览器。这么长时间下来，我也慢慢从完全不知如何上手，提个PR都困难，到现在能够负责独立开发一个比较大的功能模块了。<br><br>不得不说，Edge是我见过的最复杂的一个项目，我是真的很难想象一个浏览器工程可以庞大到如此地步。Chromium本身就已经是一个巨型工程了，而Edge又要在其基础之上加入许多微软定制的需求，那就肯定避免不了一通魔改，代码自然就变得更加复杂。<br><br>记得当初刚加入微软不久时，有一些公众号上的小伙伴还跟我提了一些建议，说Android版的Edge有哪些方式体验不够好，问我可不可以优化？<br><br>我的回答都是不可以。<br><br>说真的，这个项目连让我改个文字颜色我都觉得费劲。没进来之前觉得这多么简单的一个功能啊，进来之后才发现，任何一个看似简单的功能背后牵扯的都是一套庞大的系统。<br><br>所以，最初我的想法就是，能完成好分配给我的工作就行了，不去思考额外的事情。<br><br>但是，随着受到一些热爱产品体验的同事们的影响，我逐渐意识到Android版的Edge确实存在一些体验上的问题。并且随着我对这个项目的了解程度加深，貌似我是有能力可以去优化一些长期的体验问题的。<br><br>一旦有了这个想法之后，很快就会生根发芽，挡都挡不住。后来跟领导反复沟通之后，终于争取到了机会，可以在自己想做的事情上大展拳脚了。<br><br>这次我做的改动都是用户明显可以观察到变化的部分。其实我们平时还做了很多工作用户是轻易看不出来的，比如说提升性能，降低崩溃率等等。虽然可能没有那么明显的感知，但确实每个版本的质量都在变好。<br><br>那么就来说一说当前Android版的Edge浏览器存在哪些用户体验上的问题吧。<br><br>这是你首次安装Edge并打开后看到的界面：<br><br><div style=\"text-align: center;\"><img src=\"http://localhost:8080/Blog/upload/article/d719d60e0a834f9ab0a5cf9b7494e773.png\" style=\"max-width:100%;\"><br></div><br>看上去还不错对吗？有搜索框用于搜索内容，有热门站点用户快速访问，有精美的必应每日一图。底部还有新闻资讯，如果想要看新闻的话向下滑动即可。<br><br>但是，当你真的想要向下滑动阅读新闻的话，问题就出现了：<br><br><br><br>你会发现，当你轻轻向下滑动时，是很难滑到新闻区域的，Edge的回弹力度会很大。必须用非常快的滑动，或者滑动比较远的距离才能够成功滑到新闻区域，滑回来也是同样的道理。总之就是让人感觉很不舒服。<br><br>这其实就挺影响用户体验的，如果你以前就是Edge Android的用户，不知道有没有被这种不太友好的体验困扰过呢？<br><br>据我所知，这是一个长久以来就存在的问题了，至少从我加入Edge时就是这样。并且这东西还很难修。它就属于前面我所说的，没进来之前觉得这多么简单的一个功能，进来之后才发现，这背后真的藏着一个庞大的系统。<br><br>我倒是想在这里展开一些技术细节的讨论，但Edge毕竟不是一个开源的项目，讲太多我怕会违反公司隐私方面的一些政策。<br><br>简单来说，主要问题的原因集中在搜索框上。因为当你向下滑动查看新闻时，搜索框会跟着进行一个动画联动，从页面中间的搜索框过渡到顶部的搜索框。而这个过程是不可以有中间状态的，也就是说搜索框要么就得顶到最上面，要么就只能回弹回去。<br><br><br><br>那么为什么说它很难呢？因为这个搜索框关联到了Chromium中一个非常庞大的Toolbar系统。看不懂、改不动是我对Chromium Toolbar的一种常态化认识了。<br><br>不过这部分代码倒全部都是开源的，感兴趣的小伙伴可以去瞧一瞧：<br><a href=\"https://source.chromium.org/chromium/chromium/src/+/main:chrome/browser/ui/android/toolbar/java/src/org/chromium/chrome/browser/toolbar/top/ToolbarPhone.java\" target=\"_blank\"></a><br><p><a href=\"https://source.chromium.org/chromium/chromium/src/+/main:chrome/browser/ui/android/toolbar/java/src/org/chromium/chrome/browser/toolbar/top/ToolbarPhone.java\" target=\"_blank\">源码</a></p><br>除此之外还有什么用户体验上的问题呢？<br><br>这个可能需要考一考你的眼力了，当你想要去搜索什么东西的时候一定会点击搜索框对不对？那么点击之后的效果如下所示：<br><br><br><br>有没有看出什么问题？<br><br>没有的话很正常，因为我也一直没看出，我们很多的同事都没有看出。<br><br>但是当我将动画进行5倍速慢放的时候，我们再来看一遍：<br><br><br><br>在5倍慢镜头下，一切都是那么的明显。<br><br>这根本就是个Bug嘛。<br><br>有趣的是，当你知道有这样一个Bug之后，再回去看之前一倍速的效果图，你会发现这个点击搜索框的动画效果简直不能忍受。<br><br>至于这个Bug是如何出现的我就不在这里说了，这是我们团队内部的事情。比较讽刺的是，这个Bug在Android版的Edge上已经存在挺长时间了，但却鲜有人发现并指出这个Bug。我也是受到团队内一些热爱产品体验的同事们影响，才认识并正视了这个长期被忽视的Bug。它确实也是很影响用户体验的。<br><br>不过这个问题相比于刚才第一个问题就好修太多了，待会我会带大家看一看修复之后的效果。<br><br>接下来，你觉得Edge的主页还有什么用户体验不友好的地方吗？<br><br>我们要不要来看一看这部分：<br><br><br><br>准确来讲这里并不存在什么Bug，但是有没有觉得就是看上去很别扭呢？<br><br>拜托，今年都已经2022年了，Android系统都快出到13了，Edge竟然还没有实现沉浸式状态栏的效果？<br><br>有这种想法的小伙伴我不知道人数会有多少，但一定会有。<br><br>这个功能对于Edge来说是非常委屈的。如果是在别的App上实现沉浸式状态栏效果我可能分分钟就能搞定，但Edge是基于Chromium的项目，而Chromium并没有支持这项功能。<br><br>当然Chromium也完全不需要支持这项功能，因为Google又没有必应每日一图，所以Chrome的首页完全没有违和感：<br><br><br><br>而Edge的代码基于Chromium，效果又想做出沉浸式的样子，这就比较为难了。<br><br>我有专门去评估一下，如果想要让Edge实现沉浸式状态栏的效果需要付出多大的代价，评估下来它的难度比刚才两个问题加起来还要大好几倍。<br><br>这个功能的坑点极多，而且越做会发现坑越多。做到中途的时候我甚至怀疑自己到底能不能把这个功能实现，某个天坑蹚不过去可能就让自己前面的努力都白费了。<br><br>好在最终的结果是好的，以上提到的所有用户体验问题，都解决了。<br><br>现在最新的Edge已经发布到了101版本，这个版本带上了我对前面提到的所有影响用户体验问题的修复。大家现在去各大手机应用市场应该就能下载到Edge 101版本了。<br><br>不过，当你安装了Edge 101版本并进入Edge主页之后，你会发现前面我所提到的所有问题，仍然都还在。这是因为目前这些体验性问题的修复默认还是处于关闭的状态，大家正好也可以趁机先操作一把，感受一下我提到的这几点问题是不是都比较影响用户体验。<br><br>感受完了之后，下面我来教大家如何体验全新版本的Edge主页。<br><br>首先在Edge的地址栏输入edge://flags，你会看到如下界面：<br><br><br><br>这个界面是Edge用于配置一些实验性功能开关的界面，里面显示的都是目前Edge正处于测试阶段的一些功能。<br><br>接下来在这个界面的搜索框当中输入New NTP Experience，如下所示：<br><br><br><br>然后将这个功能的开关打开，选择Enabled选项即可：<br><br><br><br>当你选择了Enabled之后，底部会弹出一个提醒告诉你重启浏览器来使开关生效。<br><br>一般的实验性功能重启一次就可以生效了，但是我做的这个功能受制于一些技术上的限制，还得再重启一次才能生效。所以请记得，你得在重启之后手动杀掉App，再重启一次才行。<br><br>再次重启之后进入Edge主页，你将看到如下的界面：<br><br><br><br>毫无疑问，最明显最直观的变化就是，Edge主页终于变成沉浸式状态栏的效果了，仅这一点的变化就让App的视觉体验提升了不少档次。<br><br>关于沉浸式状态栏的优化我们也得到了一些用户的肯定，因为Edge Canary版是可以先行体验各种新功能的，所以不少用户在Canary版本上已经体验过了，我们得到的反馈也都是正面的。<br><br><br><br>另外在沉浸式状态栏这个功能当中我还运用了一些小黑科技，不过今天这篇文章不太适合讲技术细节，我准备后面专门再写一篇文章来跟大家讲讲这背后涉及的技术。<br><br>第一直观变化的感受体验完了之后，接下来我们可以操作看看了。<br><br>刚才有说到，在Edge主页向下滑动去查看新闻时，滑动感受非常差，回弹力度很大。而现在我们可以再试一试滑动的效果：<br><br><br><br>你将不会再感受到任何的回弹在与你作对，甚至可以用丝般顺滑来形容了。由此用户体验又上了一个台阶。<br><br>最后，我们再来看一看刚才那个5倍速慢放的Bug吧。我前面说过，从技术上来讲，这个最容易解决的一个问题，但是从用户体验提升上来说，它也毫不含糊。<br><br>5倍慢镜头下，点击搜索框，效果如下图所示：<br><br><br><br>各种动画的细节在慢镜头下一览无余，之前那奇怪的动画效果已经不复存在了。<br><br>然后我们再看看正常一倍速的效果吧：<br><br><br><br>体验方面的提升还是相当明显的吧？<br><br>好了，这些就是在最近几个月时间里，我为Android版Microsoft Edge所带来的变化。<br><br>最后，如果你还从来没有体验过Edge，那么不妨扫描下方二维码下载一波试试吧。<br><br><br>如果想要学习Kotlin和最新的Android知识，可以参考我的新书 《第一行代码 第3版》，点击此处查看详情。<br>————————————————<br>版权声明：本文为CSDN博主「guolin」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。<br>原文链接：https://blog.csdn.net/guolin_blog/article/details/124769285</p><p><br></p>', '掰手指数一数，从入职以来，我一直在从事于开发Android版的Edge浏览器。这么长时间下来，我也慢慢从完全不知如何上手，提个PR都困难，到现在能够负责独立开发一个比较大的功能模块了。\r\n\r\n不得不说，Edge是我见过的最复杂的一个项目，我是真的很难想象一个浏览器工程可以庞大到如此地步。Chromium本身就已经是一个巨型工程了，而Edge又要在其基础之上加入许多微软定制的需求，那就肯定避免不了一通魔改，代码自然就变得更加复杂。', '2022-05-27', 1, 18, 0, 'http://localhost:8080/Blog/upload/article/d719d60e0a834f9ab0a5cf9b7494e773.png');
INSERT INTO `article` VALUES (21, 2, '“由于一段 Python 代码，我的号被封了”', '<p>试想一下：当你习惯于将所有照片、视频、文件等资料全部存在网盘，结果有一天官方提示，“你的账号因违规而被禁用”，再也无法登陆网盘时，你会是什么反应？<br><br>总之，一位国外开发者 @m9nasr（以下简称为 M）在收到谷歌通知封禁其账号之后，崩溃了：“我的账户对我来说就是一切，而现在一切都没了！”</p><p><img src=\"http://localhost:8080/Blog/upload/article/c63d017f6869414a9d08fabcd5179b1d.png\" style=\"max-width:50%;\"><br></p><p><h2>一、没有谷歌帐户就没了一切</h2>事情发生在 5 月初的某天早上，M 刚醒就发现其谷歌帐户由于“有害内容”而被禁用，对此 M 第一反应就是：震惊。<br><br>可能对许多国内用户而言，不甚了解谷歌账户的重要性。具体来说，谷歌帐户就是一个统一登录系统，用户可通过注册 Gmail 获得谷歌帐户，也可使用已有的电子邮件进行申请。而有了这个谷歌帐户后，用户便可以在账户中添加一系列谷歌产品——M 就用其谷歌帐户中，存放了许多珍贵的多年回忆与重要资料。<br><br>“我从小到现在的照片（23 年的照片）、我侄女从在妈妈肚子里开始的照片、我的重要文件、所有密码、备忘录和谷歌登录账户都没了。”不仅如此，M 补充道：“还有我 Google Play 账户里的应用，谷歌扩展开发者里的扩展程序，谷歌 AdMob 里我所有的未付收入，Firebase，Google Analytics 和谷歌搜索控制台……”<br><br>对 M 而言，禁用谷歌账户就等于与以上所有内容隔绝——因为在此之前，M 没有备份重要资料的习惯。<br><br><h2>二、因为一段正常的 Python 代码？</h2>这样的后果显然是 M 无法接受的，因此 Ta 迅速给谷歌发了电子邮件询问缘由，但得到的仅是毫无意义的统一回复：你违反了我们的政策。<br><br>为此，M 只能仔细回想其账户被封之前的 48 小时内，Ta 到底做了什么才可能导致这样的结果，最终将目光聚焦在了一段 Python 代码上。</p><p><br></p><p style=\"text-align: center;\"><img src=\"http://localhost:8080/Blog/upload/article/78f6f7a7d1c947bda561785c4f948e7c.png\" style=\"max-width:100%;\"><br></p><p style=\"text-align: center;\"><br></p><p>据 M 介绍，这段 Python 代码是 Ta 自己编写的（一个下载程序，为其应用数据备份脚本），并在账号被封前 48 小时上传到驱动器以快速传输至其 RDP。<br><br>“谷歌认为这是一个有害的脚本！怎么会这样，这明明是一段正常代码！”M 抱怨道：“我很失望，也很沮丧。以前，我总是向我的朋友推荐谷歌照片来保存图像，现在我觉得我错了……”<br><br><h2>三、“重要内容需要备份”</h2>对于 M 的遭遇，部分网友表示疑惑，认为那段 Python 代码可能不是最终原因。<br><br>@MysteryBaggins：“目前，还不能确定到底是什么原因导致账号被封，可能还需要谷歌方面进行确认吧。”<br><br>有少数人认为，这种行为对于谷歌而言，早已是家常便饭。<br><br>@jimrandomh：“谷歌早已因为时不时就莫名禁止用户使用谷歌产品而闻名了，有些人怀疑可能是自动化系统出故障了。所以我每次都在考虑，如果我用的谷歌产品突然关闭，会对我造成怎样的影响？因此，我也不会向我的雇主推荐谷歌产品。”<br><br>同时，也有一些人认为 M 对重要内容不进行备份的行为欠妥：<br><br>@bkc56：“对于这种情况，我很抱歉，我无法为已被禁用的帐户提供帮助。但我想说，任何重要的东西都必须备份，只有一份绝对是不安全的，哪怕是保存在‘云’中。”<br><br>那么，你一般将大量照片或文件保存在何处？是否有对重要内容进行备份的习惯？<br><br>参考链接：<br><br><a href=\"https://old.reddit.com/r/GMail/comments/ukaauk/your_google_account_has_been_disabled_because_of/\" target=\"_blank\">https://old.reddit.com/r/GMail/comments/ukaauk/your_google_account_has_been_disabled_because_of/</a><br><br><a href=\"https://news.ycombinator.com/item?id=31390595\" target=\"_blank\">https://news.ycombinator.com/item?id=31390595</a><br>————————————————<br>版权声明：本文为CSDN博主「CSDN资讯」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。<br>原文链接：https://blog.csdn.net/csdnnews/article/details/124813425</p>', '试想一下：当你习惯于将所有照片、视频、文件等资料全部存在网盘，结果有一天官方提示，“你的账号因违规而被禁用”，再也无法登陆网盘时，你会是什么反应？总之，一位国外开发者 @m9nasr（以下简称为 M）在收到谷歌通知封禁其账号之后，崩溃了：“我的账户对我来说就是一切，而现在一切都没了！”一、没有谷歌帐户就没了一切事情发生在 5 月初的某天早上，M 刚醒就发现其谷歌帐户由于“有害内容”而被禁用，对此 M 第一反应就是：震惊。可能对许多国内用户而言，不甚了解谷歌账户的重要性。具体来说，谷歌帐户就是一个统一登录系统，用户可通过注册 Gmail 获得谷歌帐户，也可使用已有的电子邮件进行申请。而有了这个谷歌帐户后，用户便可以在账户中添加一系列谷歌产品——M 就用其谷歌帐户中，存放了许多珍贵的多年回忆与重要资料。“我从小到现在的照片（23 年的照片）、我侄女从在妈妈肚子里开始的照片、我的重要文件、所有密码、备忘录和谷歌登录账户都没了。”不仅如此，M 补充道：“还有我 Google Play 账户里的应用，谷歌扩展开发者里的扩展程序，谷歌 AdMob 里我所有的未付收入，Firebase，Google Analytics 和谷歌搜索控制台……”对 M 而言，禁用谷歌账户就等于与以上所有内容隔绝——因为在此之前，M 没有备份重要资料的习惯。二、因为一段正常的 Python 代码？这样的后果显然是 M 无法接受的，因此 Ta 迅速给谷歌发了电子邮件询问缘由，但得到的仅是毫无意义的统一回复：你违反了我们的政策。为此，M 只能仔细回想其账户被封之前的 48 小时内，Ta 到底做了什么才可能导致这样的结果，最终将目光聚焦在了一段 Python 代码上。据 M 介绍，这段 Python 代码是 Ta 自己编写的（一个下载程序，为其应用数据备份脚本），并在账号被封前 48 小时上传到驱动器以快速传输至其 RDP。“谷歌认为这是一个有害的脚本！怎么会这样，这明明是一段正常代码！”M 抱怨道：“我很失望，也很沮丧。以前，我总是向我的朋友推荐谷歌照片来保存图像，现在我觉得我错了……”三、“重要内容需要备份”对于 M 的遭遇，部分网友表示疑惑，认为那段 Python 代码可能不是最终原因。@MysteryBaggins：“目前，还不能确定到底是什么原因导致账号被封，可能还需要谷歌方面进行确认吧。”有少数人认为，这种行为对于谷歌而言，早已是家常便饭。@jimrandomh：“谷歌早已因为时不时就莫名禁止用户使用谷歌产品而闻名了，有些人怀疑可能是自动化系统出故障了。所以我每次都在考虑，如果我用的谷歌产品突然关闭，会对我造成怎样的影响？因此，我也不会向我的雇主推荐谷歌产品。”同时，也有一些人认为 M 对重要内容不进行备份的行为欠妥：@bkc56：“对于这种情况，我很抱歉，我无法为已被禁用的帐户提供帮助。但我想说，任何重要的东西都必须备份，只有一份绝对是不安全的，哪怕是保存在‘云’中。”那么，你一般将大量照片或文件保存在何处？是否有对重要内容进行备份的习惯？参考链接：https://old.reddit.com/r/GMail/comments/ukaauk/your_google_account_has_been_disabled_because_of/https://news.ycombinator.com/item?id=31390595————————————————版权声明：本文为CSDN博主「CSDN资讯」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。原文链接：https://blog.csdn.net/csdnnews/article/details/124813425', '2022-05-26', 1, 21, 0, 'http://localhost:8080/Blog/upload/article/c63d017f6869414a9d08fabcd5179b1d.png');
INSERT INTO `article` VALUES (22, 2, '警惕AI复制，几张图片就能实现视频伪造', '<p></p><h2><span style=\"font-weight: bold;\">前言</span></h2><p>前端时间悬疑剧《猎罪图鉴》热播，其中一个利用AI技术换脸进行诈骗的剧情，不少人被骗得倾家荡产，最终酿成自杀身亡的悲剧。而这不仅在影视剧中才能出现，在现实生活中，已经出现了不少AI变声换脸诈骗。<br><br>首先诈骗团伙通过电话录音等方式提取到声音素材，再在网上搜集公众发布的照片、视频等信息，通过AI技术将所搜集的素材进行合成，这样一个难以用肉眼进行区分的“伪视频”就制作完毕。<br><br>而这其实就是深伪技术。它是一种人工智能深度学习技术，通过对伪造事物的识别，再经过分析学习，当样本量足够多时，人工智能就会掌握原对象的特征。学习完成后，计算机就可以将人物形象、语言、背景拼合成近似完美的虚拟人物，这样，一段高仿视频就制作完毕。<br><br>上述过程看上去很难，但是随着技术的不断发展，使用门槛也在不断降低，通过一些开源软件，非专业的人员也能完成视频伪造。<br><br>而今天将介绍这项技术：DeepFake，能够实现AI换脸，然后再谈谈这个问题带来的影响以及如何<span style=\"font-weight: bold;\">解决这个问题。</span><br></p><p></p><p><img src=\"http://localhost:8080/Blog/upload/article/6db273045ced47cdadf88e81fadfcf2b.png\" style=\"max-width: 100%;\"><br></p><p></p><h2><span style=\"font-weight: bold;\">一、DeepFake技术介绍</span></h2><p>深度伪造一词译自英文“Deepfake”(“deep learning”和“fake”的组合)，最初源于一个名为“deepfakes”的Reddit社交网站用户, 该用户于2017年12月在 Reddit 社交网站上发布了将斯嘉丽·约翰逊等女演员的面孔映射至色情表演者身上的伪造视频。<br>Deepfake目前在国际上并没有公认的统一定义, 美国在其发布的《2018 年恶意伪造禁令法 案》中将“deep fake”定义为“以某种方式使合理的观察者错误地将其视为个人真实言语或行为的真实记录的方式创建或更改的视听记录”, 其中“视听记录”即指图像、视频和语音等数字内容。<br><br><span style=\"font-weight: bold;\">视频伪造：</span><br><br>视频伪造是Deepfake技术最为主要的代表，制作假视频的技术也被称为AI换脸技术（AI face swap)。其核心原理是<span style=\"font-weight: bold;\">利用生成对抗网络或者卷积神经网络等算法将目标对象的面部“嫁接”到被模仿对象上。</span>由于视频是连续的图片组成，因此只需要把每一张图片中的脸替换，就能得到变脸的新视频。具体而言，首先将模仿对象的视频逐帧转化成大量图片，然后将目标模仿对象面部替换成目标对象面部。最后，将替换完成的图片重新合成为假视频，而深度学习技术可以使这一过程实现自动化，主要采用自动编解码器以及生成对抗网络技术。</p><p></p><h2 style=\"margin-top: 8px; margin-bottom: 16px; font-weight: 700; line-height: 30px; outline: 0px; font-family: &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, SimHei, Arial, SimSun; font-size: 22px; color: rgb(79, 79, 79); overflow-wrap: break-word;\">二、实现途径</h2><p style=\"margin-top: 0px; margin-bottom: 16px; outline: 0px; font-size: 16px; color: rgb(77, 77, 77); overflow: auto hidden; overflow-wrap: break-word; font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif, SimHei, SimSun; line-height: 26px !important;\">接下来将介绍如何使用DeepFaceLab开源项目进行AI换脸。</p><p style=\"margin-top: 0px; margin-bottom: 16px; outline: 0px; font-size: 16px; color: rgb(77, 77, 77); overflow: auto hidden; overflow-wrap: break-word; font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif, SimHei, SimSun; line-height: 26px !important;\">首先我们需要从GitHub上克隆该项目<a href=\"https://github.com/iperov/DeepFaceLab#deepfacelab-is-a-tool-that-utilizes-machine-learning-to-replace-faces-in-videos\" title=\"DeepFaceLab\" style=\"color: rgb(78, 161, 219); outline: none; cursor: pointer; overflow-wrap: break-word;\">DeepFaceLab</a>，如下图所示：</p><p><img src=\"http://localhost:8080/Blog/upload/article/17388a4481ff490d85f08773e90f9923.png\" style=\"max-width: 100%;\"><br></p><p style=\"margin-top: 0px; margin-bottom: 16px; outline: 0px; font-size: 16px; color: rgb(77, 77, 77); overflow: auto hidden; overflow-wrap: break-word; font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif, SimHei, SimSun; line-height: 26px !important;\">这里面包含两个文件夹，和一堆bat批处理指令。</p><ul style=\"margin-top: 0px; margin-bottom: 24px; margin-left: 0px; outline: 0px; list-style: none; font-size: 16px; overflow-wrap: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif, SimHei, SimSun;\"><li style=\"margin-top: 8px; margin-left: 32px; list-style-type: disc; outline: 0px; overflow-wrap: break-word;\">internal：存放源代码相关的内容</li><li style=\"margin-top: 8px; margin-left: 32px; list-style-type: disc; outline: 0px; overflow-wrap: break-word;\">workspace：工作目录</li><li style=\"margin-top: 8px; margin-left: 32px; list-style-type: disc; outline: 0px; overflow-wrap: break-word;\">bat：&nbsp;脚本批处理文件，调用代码</li></ul><div><p style=\"margin-top: 0px; margin-bottom: 16px; outline: 0px; font-size: 16px; color: rgb(77, 77, 77); overflow: auto hidden; overflow-wrap: break-word; font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif, SimHei, SimSun; line-height: 26px !important;\"><span style=\"outline: 0px; font-weight: 700; overflow-wrap: break-word;\">执行步骤：</span></p><ol style=\"margin-top: 0px; margin-bottom: 24px; margin-left: 0px; outline: 0px; list-style: none; font-size: 16px; overflow-wrap: break-word; color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif, SimHei, SimSun;\"><li style=\"margin-top: 8px; margin-left: 40px; list-style-type: decimal; outline: 0px; overflow-wrap: break-word;\">源视频转成图片（源图片）</li><li style=\"margin-top: 8px; margin-left: 40px; list-style-type: decimal; outline: 0px; overflow-wrap: break-word;\">目标视频转成图片（目标图片）</li><li style=\"margin-top: 8px; margin-left: 40px; list-style-type: decimal; outline: 0px; overflow-wrap: break-word;\">从源图片中提取源脸部信息</li><li style=\"margin-top: 8px; margin-left: 40px; list-style-type: decimal; outline: 0px; overflow-wrap: break-word;\">从目标图片中提取目标脸部信息</li><li style=\"margin-top: 8px; margin-left: 40px; list-style-type: decimal; outline: 0px; overflow-wrap: break-word;\">使用脸部信息头像训练模型（Model）</li><li style=\"margin-top: 8px; margin-left: 40px; list-style-type: decimal; outline: 0px; overflow-wrap: break-word;\">使用模型进行图片换脸</li><li style=\"margin-top: 8px; margin-left: 40px; list-style-type: decimal; outline: 0px; overflow-wrap: break-word;\">将换完脸的图片合成视频导出</li></ol><div><img src=\"http://localhost:8080/Blog/upload/article/bcc6093c766c42218b1936adff70257c.png\" style=\"max-width: 100%;\"><span style=\"color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif, SimHei, SimSun; font-size: 16px;\"><br></span></div></div><h2 style=\"margin-top: 8px; margin-bottom: 16px; font-weight: 700; line-height: 30px; outline: 0px; font-family: &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, SimHei, Arial, SimSun; font-size: 22px; color: rgb(79, 79, 79); overflow-wrap: break-word;\">三、效果展示</h2><p style=\"margin-top: 0px; margin-bottom: 16px; outline: 0px; font-size: 16px; color: rgb(77, 77, 77); overflow: auto hidden; overflow-wrap: break-word; font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif, SimHei, SimSun; line-height: 26px !important;\">经过几个小时的训练，合成视频结果如下所示：</p><p><img src=\"http://localhost:8080/Blog/upload/article/008dad16f9004696ab0584bb96f1cd44.png\" style=\"max-width: 100%;\"><br></p><h2 style=\"margin-top: 8px; margin-bottom: 16px; font-weight: 700; line-height: 30px; outline: 0px; font-family: &quot;PingFang SC&quot;, &quot;Microsoft YaHei&quot;, SimHei, Arial, SimSun; font-size: 22px; color: rgb(79, 79, 79); overflow-wrap: break-word;\">四、总结</h2><p style=\"margin-top: 0px; margin-bottom: 16px; outline: 0px; font-size: 16px; color: rgb(77, 77, 77); overflow: auto hidden; overflow-wrap: break-word; font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif, SimHei, SimSun; line-height: 26px !important;\">从AI换脸这一技术诞生起，大众对它的争议就从未停止过。诚然，每一项新兴技术给我们带来了便利，也存在着颠覆伦理道德和冲击安全底线的风险，急需行为道德和法律规范的双重<a href=\"https://so.csdn.net/so/search?q=%E7%BA%A6%E6%9D%9F&amp;spm=1001.2101.3001.7020\" target=\"_blank\" style=\"margin-right: 3px; padding-right: 14px; padding-left: 3px; color: rgb(252, 85, 49); outline: none; cursor: pointer; overflow-wrap: break-word; border-radius: 3px; background: url(&quot;../img/iconHighlight.svg&quot;) right top / 12px 14px no-repeat transparent; box-shadow: none;\">约束</a>。</p><p style=\"margin-top: 0px; margin-bottom: 16px; outline: 0px; font-size: 16px; color: rgb(77, 77, 77); overflow: auto hidden; overflow-wrap: break-word; font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif, SimHei, SimSun; line-height: 26px !important;\">而分享出这篇文章，会不会有人在本文的启发下做出恶意行为呢？事实上，不论是否由本文来介绍，该技术事实上就是存在的！</p><p style=\"margin-top: 0px; margin-bottom: 16px; outline: 0px; font-size: 16px; color: rgb(77, 77, 77); overflow: auto hidden; overflow-wrap: break-word; font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif, SimHei, SimSun; line-height: 26px !important;\">我们更加需要做的是唤醒更多人在虚假视频这方面的安全意识，从而促进研究相关的反制措施，分享出本文，利远大于弊。</p><p style=\"margin-top: 0px; margin-bottom: 16px; outline: 0px; font-size: 16px; color: rgb(77, 77, 77); overflow: auto hidden; overflow-wrap: break-word; font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif, SimHei, SimSun; line-height: 26px !important;\">最后也是最重要的，<span style=\"outline: 0px; font-weight: 700; overflow-wrap: break-word;\">那就是在坚守道德底线的同时，始终记得科技是服务于我们的工具，而不是控制我们的漩涡。</span></p>', '前言前端时间悬疑剧《猎罪图鉴》热播，其中一个利用AI技术换脸进行诈骗的剧情，不少人被骗得倾家荡产，最终酿成自杀身亡的悲剧。而这不仅在影视剧中才能出现，在现实生活中，已经出现了不少AI变声换脸诈骗。首先诈骗团伙通过电话录音等方式提取到声音素材，再在网上搜集公众发布的照片、视频等信息，通过AI技术将所搜集的素材进行合成，这样一个难以用肉眼进行区分的“伪视频”就制作完毕。而这其实就是深伪技术。它是一种人工智能深度学习技术，通过对伪造事物的识别，再经过分析学习，当样本量足够多时，人工智能就会掌握原对象的特征。学习完成后，计算机就可以将人物形象、语言、背景拼合成近似完美的虚拟人物，这样，一段高仿视频就制作完毕。上述过程看上去很难，但是随着技术的不断发展，使用门槛也在不断降低，通过一些开源软件，非专业的人员也能完成视频伪造。而今天将介绍这项技术：DeepFake，能够实现AI换脸，然后再谈谈这个问题带来的影响以及如何解决这个问题。一、DeepFake技术介绍深度伪造一词译自英文“Deepfake”(“deep learning”和“fake”的组合)，最初源于一个名为“deepfakes”的Reddit社交网站用户, 该用户于2017年12月在 Reddit 社交网站上发布了将斯嘉丽·约翰逊等女演员的面孔映射至色情表演者身上的伪造视频。Deepfake目前在国际上并没有公认的统一定义, 美国在其发布的《2018 年恶意伪造禁令法 案》中将“deep fake”定义为“以某种方式使合理的观察者错误地将其视为个人真实言语或行为的真实记录的方式创建或更改的视听记录”, 其中“视听记录”即指图像、视频和语音等数字内容。视频伪造：视频伪造是Deepfake技术最为主要的代表，制作假视频的技术也被称为AI换脸技术（AI face swap)。其核心原理是利用生成对抗网络或者卷积神经网络等算法将目标对象的面部“嫁接”到被模仿对象上。由于视频是连续的图片组成，因此只需要把每一张图片中的脸替换，就能得到变脸的新视频。具体而言，首先将模仿对象的视频逐帧转化成大量图片，然后将目标模仿对象面部替换成目标对象面部。最后，将替换完成的图片重新合成为假视频，而深度学习技术可以使这一过程实现自动化，主要采用自动编解码器以及生成对抗网络技术。二、实现途径接下来将介绍如何使用DeepFaceLab开源项目进行AI换脸。首先我们需要从GitHub上克隆该项目DeepFaceLab，如下图所示：这里面包含两个文件夹，和一堆bat批处理指令。internal：存放源代码相关的内容workspace：工作目录bat：&nbsp;脚本批处理文件，调用代码执行步骤：源视频转成图片（源图片）目标视频转成图片（目标图片）从源图片中提取源脸部信息从目标图片中提取目标脸部信息使用脸部信息头像训练模型（Model）使用模型进行图片换脸将换完脸的图片合成视频导出三、效果展示经过几个小时的训练，合成视频结果如下所示：四、总结从AI换脸这一技术诞生起，大众对它的争议就从未停止过。诚然，每一项新兴技术给我们带来了便利，也存在着颠覆伦理道德和冲击安全底线的风险，急需行为道德和法律规范的双重约束。而分享出这篇文章，会不会有人在本文的启发下做出恶意行为呢？事实上，不论是否由本文来介绍，该技术事实上就是存在的！我们更加需要做的是唤醒更多人在虚假视频这方面的安全意识，从而促进研究相关的反制措施，分享出本文，利远大于弊。最后也是最重要的，那就是在坚守道德底线的同时，始终记得科技是服务于我们的工具，而不是控制我们的漩涡。', '2022-05-25', 1, 41, 0, 'http://localhost:8080/Blog/upload/article/6db273045ced47cdadf88e81fadfcf2b.png');
INSERT INTO `article` VALUES (25, 2, '测试文章封面', '<h1 style=\"font-family: &quot;Helvetica Neue&quot;, Helvetica, &quot;Noto Sans&quot;, sans-serif, Arial, sans-serif;\">测试文章封面</h1>', '测试文章封面', '2022-06-01', 1, 12, 0, 'http://localhost:8080/Blog/upload/article/4a85fa84d8fc41beb36e810640c3a801.png');
INSERT INTO `article` VALUES (32, 2, '测试文章专栏分类-修改', '<h1>测试文章专栏分类-修改</h1>', '测试文章专栏分类-修改', '2022-06-04', 1, 9, 0, 'http://localhost:8080/Blog/upload/article/5da855d7115841ceafe0f812a1359a6f.jpg');
INSERT INTO `article` VALUES (33, 2, '最后测试', '<p>最后测试</p>', '最后测试', '2022-06-05', 2, 0, 0, 'http://localhost:8080/Blog/upload/article/387b3af082754b2c99c12ff2ebe76a8e.png');

-- ----------------------------
-- Table structure for articletag
-- ----------------------------
DROP TABLE IF EXISTS `articletag`;
CREATE TABLE `articletag`  (
  `aid` int(0) NOT NULL,
  `tid` int(0) NOT NULL,
  PRIMARY KEY (`aid`, `tid`) USING BTREE,
  INDEX `a-t2`(`tid`) USING BTREE,
  CONSTRAINT `a-t` FOREIGN KEY (`aid`) REFERENCES `article` (`aid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `a-t2` FOREIGN KEY (`tid`) REFERENCES `tag` (`tid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of articletag
-- ----------------------------
INSERT INTO `articletag` VALUES (17, 1);
INSERT INTO `articletag` VALUES (33, 1);
INSERT INTO `articletag` VALUES (17, 2);
INSERT INTO `articletag` VALUES (17, 3);
INSERT INTO `articletag` VALUES (19, 4);
INSERT INTO `articletag` VALUES (19, 5);
INSERT INTO `articletag` VALUES (19, 6);
INSERT INTO `articletag` VALUES (21, 7);
INSERT INTO `articletag` VALUES (21, 8);
INSERT INTO `articletag` VALUES (21, 9);
INSERT INTO `articletag` VALUES (22, 10);
INSERT INTO `articletag` VALUES (32, 10);
INSERT INTO `articletag` VALUES (22, 11);
INSERT INTO `articletag` VALUES (22, 12);
INSERT INTO `articletag` VALUES (32, 12);
INSERT INTO `articletag` VALUES (33, 13);

-- ----------------------------
-- Table structure for column
-- ----------------------------
DROP TABLE IF EXISTS `column`;
CREATE TABLE `column`  (
  `cid` int(0) NOT NULL AUTO_INCREMENT COMMENT '专栏id',
  `uid` int(0) NOT NULL COMMENT '创建者id',
  `cname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专栏名称',
  PRIMARY KEY (`cid`, `uid`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of column
-- ----------------------------
INSERT INTO `column` VALUES (1, 2, 'Java学习');
INSERT INTO `column` VALUES (2, 2, 'SSM学习');

-- ----------------------------
-- Table structure for column_article
-- ----------------------------
DROP TABLE IF EXISTS `column_article`;
CREATE TABLE `column_article`  (
  `cid` int(0) NOT NULL,
  `aid` int(0) NOT NULL,
  `uid` int(0) NOT NULL,
  PRIMARY KEY (`cid`, `aid`, `uid`) USING BTREE,
  CONSTRAINT `c-a` FOREIGN KEY (`cid`) REFERENCES `column` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of column_article
-- ----------------------------
INSERT INTO `column_article` VALUES (1, 21, 2);
INSERT INTO `column_article` VALUES (1, 32, 2);
INSERT INTO `column_article` VALUES (1, 33, 2);
INSERT INTO `column_article` VALUES (2, 22, 2);

-- ----------------------------
-- Table structure for download
-- ----------------------------
DROP TABLE IF EXISTS `download`;
CREATE TABLE `download`  (
  `did` int(0) NOT NULL AUTO_INCREMENT COMMENT '资源id',
  `dname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名',
  `uid` int(0) NULL DEFAULT NULL COMMENT '上传者id',
  `loadtime` date NULL DEFAULT NULL COMMENT '上传时间',
  `dmiaoshu` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源描述',
  `dfile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源路径',
  `dformat` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源格式',
  `state` int(0) NULL DEFAULT 2 COMMENT '状态',
  `downloadtime` int(0) NULL DEFAULT 0 COMMENT '下载次数',
  PRIMARY KEY (`did`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of download
-- ----------------------------
INSERT INTO `download` VALUES (1, '资源标题', 2, '2022-06-03', '资源描述', 'upload/download/b9307b0d599e4676a6567f37624dbc2b.docx', 'docx', 1, 10);
INSERT INTO `download` VALUES (2, '软件测试文档', 2, '2022-06-03', '软件测试文档', 'upload/download/e91d033bcae14d1a89cd3dc39c5a8fa3.docx', 'docx', 1, 9);
INSERT INTO `download` VALUES (3, '测试审核', 2, '2022-06-04', '测试审核用的资源', 'upload/download/8f66c0133023459ab96cda939368577d.ppt', 'ppt', 1, 8);
INSERT INTO `download` VALUES (4, 'EXCLE上传测试', 2, '2022-06-05', 'WBS数据字典', 'upload/download/6f7a667f154b489aa388c16cb06a6412.xlsx', 'xlsx', 1, 0);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `mid` int(0) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `uid` int(0) NULL DEFAULT NULL COMMENT '评论人id',
  `aid` int(0) NULL DEFAULT NULL COMMENT '被评论文章',
  `messagetime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '评论日期',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  PRIMARY KEY (`mid`) USING BTREE,
  INDEX `m-u`(`uid`) USING BTREE,
  INDEX `m-a`(`aid`) USING BTREE,
  CONSTRAINT `m-a` FOREIGN KEY (`aid`) REFERENCES `article` (`aid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `m-u` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, 2, 22, '2022-06-05 17:06:24', '写的真好');
INSERT INTO `message` VALUES (2, 2, 22, '2022-06-05 17:16:20', '膜拜大佬');

-- ----------------------------
-- Table structure for pending
-- ----------------------------
DROP TABLE IF EXISTS `pending`;
CREATE TABLE `pending`  (
  `pid` int(0) NOT NULL AUTO_INCREMENT COMMENT '审核id',
  `uid` int(0) NULL DEFAULT NULL COMMENT '被审核人id',
  `ptitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被审核标题',
  `type` int(0) NULL DEFAULT NULL COMMENT '审核类型、1：审核文章，2：审核资源',
  `paid` int(0) NULL DEFAULT NULL COMMENT '审核人id',
  `pdate` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '审核日期',
  `presult` int(0) NULL DEFAULT NULL COMMENT '审核结果；1：通过，2：驳回',
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pending
-- ----------------------------
INSERT INTO `pending` VALUES (6, 2, '测试文章专栏分类', 1, 1, '2022-06-04 19:01:56', 2);
INSERT INTO `pending` VALUES (7, 2, '测试文章专栏分类', 1, 1, '2022-06-04 19:02:16', 1);
INSERT INTO `pending` VALUES (9, 2, '资源标题', 2, 1, '2022-06-04 22:15:17', 2);
INSERT INTO `pending` VALUES (10, 2, '资源标题', 2, 1, '2022-06-04 22:17:23', 1);
INSERT INTO `pending` VALUES (11, 2, '测试审核', 2, 1, '2022-06-04 22:22:01', 1);
INSERT INTO `pending` VALUES (12, 2, '测试文章专栏分类-修改', 1, 1, '2022-06-04 23:45:33', 1);
INSERT INTO `pending` VALUES (13, 2, '软件测试文档', 2, 1, '2022-06-05 00:59:11', 1);
INSERT INTO `pending` VALUES (14, 2, 'EXCLE上传测试', 2, 1, '2022-06-05 01:01:34', 1);

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `tid` int(0) NOT NULL AUTO_INCREMENT,
  `tagname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (1, 'Java');
INSERT INTO `tag` VALUES (2, 'Spring');
INSERT INTO `tag` VALUES (3, '前端');
INSERT INTO `tag` VALUES (4, 'SpringMVC');
INSERT INTO `tag` VALUES (5, 'MySQL');
INSERT INTO `tag` VALUES (6, 'HTML');
INSERT INTO `tag` VALUES (7, 'CSS');
INSERT INTO `tag` VALUES (8, 'Vue');
INSERT INTO `tag` VALUES (9, 'Javascript');
INSERT INTO `tag` VALUES (10, 'Android');
INSERT INTO `tag` VALUES (11, '后端');
INSERT INTO `tag` VALUES (12, '大数据');
INSERT INTO `tag` VALUES (13, '移动开发');
INSERT INTO `tag` VALUES (14, '人工智能');
INSERT INTO `tag` VALUES (15, '数据结构与算法');
INSERT INTO `tag` VALUES (16, 'Python');
INSERT INTO `tag` VALUES (17, 'PHP');
INSERT INTO `tag` VALUES (19, '标签名修改测试');
INSERT INTO `tag` VALUES (20, 'SpringBoot');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户电话',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `registeredtime` date NULL DEFAULT NULL COMMENT '注册时间',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '这家伙很懒，什么都没写……' COMMENT '个人介绍',
  `status` int(0) NULL DEFAULT 1 COMMENT '账号状态',
  `headshot` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'GTC', '33333', '18779434618', '1542908150@qq.com', '2022-05-16', '这家伙很懒，什么都没写……', 1, 'upload/a804e268a0154a1bba23413c3a777f6e.png');
INSERT INTO `user` VALUES (2, 'gutaicheng', '321', '137666666', '30379@qq.com', '2022-04-05', '我是赵甲第', 1, 'upload/894867bf83fb46fa8bc3a0dc5a9afb4d.jpg');
INSERT INTO `user` VALUES (4, 'yht', '999', '185283000', '30379@qq.com', '2022-04-12', '这家伙很懒，什么都没写……', 0, 'upload/22cb84f55bf142be9543094eebf42efb.png');
INSERT INTO `user` VALUES (8, 'bob', 'sbsb', '250250250', '25022@qq.com', '2022-04-25', '这家伙很懒，什么都没写……', 0, 'upload/c828cce07b424f6e893aeddfa122760e.png');
INSERT INTO `user` VALUES (18, '王五', '333', '13762452819', '1542908150@qq.com', '2022-05-09', '这家伙很懒，什么都没写……', 0, NULL);
INSERT INTO `user` VALUES (25, 'admin', '3', '13762452819', '1542908150@qq.com', '2022-05-09', '这家伙很懒，什么都没写……', 1, NULL);
INSERT INTO `user` VALUES (27, 'admin', '3', '18779434618', '1542908150@qq.com', '2022-05-09', '这家伙很懒，什么都没写……', 0, NULL);
INSERT INTO `user` VALUES (28, 'admin', '333666', '13762452819', '1542908150@qq.com', '2022-05-03', '这家伙很懒，什么都没写……', 0, NULL);
INSERT INTO `user` VALUES (29, 'admin', '333666', '13762452819', '1542908150@qq.com', '2022-05-03', '这家伙很懒，什么都没写……', 1, NULL);
INSERT INTO `user` VALUES (31, '刘浩成', '123456', '13762452819', '1542908150@qq.com', '2022-05-09', '这家伙很懒，什么都没写……', 1, NULL);

SET FOREIGN_KEY_CHECKS = 1;
