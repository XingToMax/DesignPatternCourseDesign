# 建立一个Spring mvc项目，Hello world！
**Author : ToMax**

> 在这篇博客中，将完整的呈现如何建立一个Spring mvc应用，包括项目的建立、一些额外的依赖的引入以及Hello world

## 建立一个Spring 项目

#### 第一步，Create new project，选择左侧的Spring项，并勾选Spring MVC、Web Application、

![](https://tomax.xin/img/blog/cd/1.png)
![](https://tomax.xin/img/blog/cd/2.png)

#### 第二步，选择Next，进入项目保存路径界面,填写项目名称

+ 点击Finish后，IDE会帮助去下载相应的依赖，下载完成后就可以打开项目

![](https://tomax.xin/img/blog/cd/3.png)

+ 项目打开后界面

![](https://tomax.xin/img/blog/cd/4.png)

+ 项目目录

多了`web`目录，里面会写一些`web`的代码，以及放`web`配置


#### 第三步，配置Tomcat
>记得，上一篇中，下载完tomcat后，只是做了解压处理，这里，在IDEA中配置tomcat容器

+ 选择程序启动项的Edit Configurations

![](https://tomax.xin/img/blog/cd/5.png)

+ 选择添加一种运行方案，这里选择tomcat的容器

![](https://tomax.xin/img/blog/cd/6.png)

+ 配置添加一个tomcat容器

![](https://tomax.xin/img/blog/cd/7.png)

![](https://tomax.xin/img/blog/cd/8.png)

+ 选择Tomcat的解压路径（该目录下包含bin、conf等目录）

![](https://tomax.xin/img/blog/cd/9.png)

![](https://tomax.xin/img/blog/cd/10.png)

+ 选择OK

![](https://tomax.xin/img/blog/cd/11.png)

+ 点击Fix处理一个问题

![](https://tomax.xin/img/blog/cd/12.png)

+ 点击Fix 后，问题会自动解决，进入下面的界面

![](https://tomax.xin/img/blog/cd/13.png)

+ 切回server tab页

![](https://tomax.xin/img/blog/cd/14.png)

#### 第四步，处理一些项目依赖问题

+ 点击Project structure

![](https://tomax.xin/img/blog/cd/15.png)

+ Fix

![](https://tomax.xin/img/blog/cd/16.png)

+ 点击OK返回

#### 第五步，启动

+ 点击绿色倒三角标启动，稍等片刻，弹出浏览器显示一下信息则启动成功

![](https://tomax.xin/img/blog/cd/17.png)

+ 还不是很明显，所以，我们来修改web目录下的index.jsp

![](https://tomax.xin/img/blog/cd/18.png)

+ 因为只是更改了网页部分，没有需要重新编译的java项，所以只需要选择update即可，操作如图

![](https://tomax.xin/img/blog/cd/19.png)

+ 更新后回到浏览器F5刷新后如图，发现index已更新，所以由idea默认生成的index.jsp即为默认访问的页面

![](https://tomax.xin/img/blog/cd/20.png)

+ 这里，不妨再啰嗦下，在web目录下新建一个login.jsp，并填写相应的内容，详细见图

![](https://tomax.xin/img/blog/cd/21.png)
![](https://tomax.xin/img/blog/cd/22.png)

+ 点击运行项，update 一下，刷新浏览器，并将地址栏修改为localhost:8080/login.jsp，如图

![](https://tomax.xin/img/blog/cd/23.png)

+ 下面尝试将默认启动的网页改为index.jsp，首先，找到WEB-INF目录下的web.xml

![](https://tomax.xin/img/blog/cd/24.png)

+ 在工作区添加以下代码

``` xml
<welcome-file-list>
    <welcome-file>login.jsp</welcome-file>
</welcome-file-list>
```
![](https://tomax.xin/img/blog/cd/25.png)

+ 点击run，重启服务器(Restart server)[快捷键为shift+f10]

![](https://tomax.xin/img/blog/cd/26.png)

+ 发现默认路径已经改为了login.jsp，好了，现在切回正题

#### 第六步，增加spring的配置与依赖

+ 这里我将采用基于java配置spring，而不是使用传统的xml文件进行配置，以减轻额外学习xml的成本

+ 首先，暂时删除WEB-INF目录下的applicationContext.xml、dispatcher-servlet.xml，同时将web.xml中web-app标签内除了刚刚增加的welcome-file-list标签以外的内容，删除多余的内容的目的是防止与之后基于java的配置产生冲突

![](https://tomax.xin/img/blog/cd/27.png)

+ 然后在lib目录里添加servlet、jackson、dbcp、mysql-connector-java的依赖，这四个依赖在github本项目中的同级lib目录下可以获取，直接拷贝即可

![](https://tomax.xin/img/blog/cd/28.png)

+ 对于jar包，需要分别add as library，**每个目录下**(千万别所有目录一起添加了，每个目录下的内容都是一个整体)全部选中集中添加一次即可

![](https://tomax.xin/img/blog/cd/29.png)

+ 添加后如图

![](https://tomax.xin/img/blog/cd/30.png)

+ 然后需要点开Project structure, Fix problems，均为add to artifact

![](https://tomax.xin/img/blog/cd/31.png)

+ 之后，我们需要创建java的开发目录，在src目录下添加如下包（右键或者alt+insert呼出菜单栏）

![](https://tomax.xin/img/blog/cd/32.png)

![](https://tomax.xin/img/blog/cd/33.png)

+ 右键建好的包，选择show in explorer 进入对应的文件夹

![](https://tomax.xin/img/blog/cd/34.png)
![](https://tomax.xin/img/blog/cd/35.png)

+ 进入tomax目录，建立如下图所示几个文件夹，其中configuration是配置java的文件夹，res是资源目录，utils是工具目录，其他的目录意义将在下一篇博客中进行详细的解释，res和utils目录并非必须，也可以根据喜好来命名

![](https://tomax.xin/img/blog/cd/36.png)

+ 下面要在configuration目录下添加spring框架的配置java文件，为了降低难度，直接从github本项目相应的目录下复制四个java文件进入即可，当作默认配置好的就好，后面用到时会做具体的解释(可能复制时会因为不同人对应包名的命名不同，所以可能需要调整包名，但正常情况下idea会帮助我们自动调整)

![](https://tomax.xin/img/blog/cd/37.png)

复制完成后，还要对其中的一些信息作调整

首先是`WebConfig`，其中有一个类注解为`@ComponentScan("cn.nuaa.tomax")`，需要将`cn.nuaa.tomax`修改为自己同级包的名称

接着是`RootConfig`，将其中的`@CompoentScan`的`backPackages`中的`cn.nuaa.tomax`改为自己的包名

最后是`AppConfig`，将`@ComponentScan`的`cn.nuaa.tomax`的值修改为自己的包名

+ 至此，配置内容算是添加完成了

#### 第七步，Hello world

+ 首先，需要在cn.nuaa.tomax.controller包下添加一个HelloWorldController.

![](https://tomax.xin/img/blog/cd/38.png)

+ 打开HelloWorldController ，添加如下代码

``` java
@Controller
@RequestMapping("/")
public class HelloWorldController {
    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String sayHello() {
        return "index";
    }
}
```
这里，简单解释下这个controller的作用

自上而下看，第一个出现的是一个叫做`@Controller`的东西，在java中，这种形式叫做注解，用来做代码级别的说明，简单理解就是一种元数据，通过这些元数据，程序可以获取一些代码相关的信息，运用反射技术(反射在这里不再扩展，不然又会引入更多的概念，有机会会补充在以后的博客中，有兴趣的同学可以去了解下，不过反射本身存在一定的理解难度，不准备深入掌握java开发的同学可以忽视它)，可以让程序解读注解信息，从而使程序具有一定主动执行的能力，而不是完全被动地处理程序员的编码。

回归正题，`@Controller`注解的作用即标注这个类的角色是一个controller，熟悉MVC的同学对此一定不会陌生。

这个controller的访问地址靠`@RequestMapping`来注解，它的参数为`"/"`，对应服务器访问的根目录，即`localhost:8080/`，那么可以确定，假设这里填的是``@RequestMapping("/path")``,那么对应的访问路径即为`localhost:8080/path`。

继续看类中定义的`sayHello()`方法，同样使用了`@RequestMapping`注解申明。`sayHello()`的``RequestMapping``注解中有两个参数，`"/hello"`表示该方法的访问地址，即`localhost:8080/hello`，假设该类的访问地址为`localhost:8080/path`的话，`sayhello()`的访问地址就变成了，`localhost:8080/path/hello`，同时第二个参数为``RequestMethod.GET``（关于http的请求方法，自行百度，主要用到的有GET方法和POST方法），即该方法将会处理的是以GET方法访问`localhost:8080/hello`的请求。

现在，大致清楚了该方法的作用，即处理以GET方法访问`localhost:8080/hello`的请求，下面说明它是如何处理的

在`sayHello()`方法中只写了`return "index";`,它的意义是会通过在config配置好的`resolver`(已经作为默认配置在之前提供，对应config/WebConfig中的viewReslover)将`index`这个字符串映射到一个具体的`view`(MVC中view的概念)中(按照已经作的配置，会映射到web目录下的index.jsp上)，即访问`localhost:8080/hello`会访问`index.jsp`

那么，我们重启一下服务器(即运行中的restart server 选项)，重启成功后，在地址栏输入`localhost:8080/hello`，将会发现，网页从默认的`login.jsp`跳转到了`index.jsp`

![](https://tomax.xin/img/blog/cd/39.png)

在上述的`sayHello()`方法中，只是单纯的通过字符串返回了一个jsp，而没有进行任何的附加值，但是实际的应用中，我们需要为这个请求添加一些在服务端产生的数据，而这种操作往往是通过`model`（MVC中model的概念）在`view`中加以呈现，在java中有一种非常简单的方法实现这种目的，即通过在`sayHello()`(即处理当前请求的方法中)增加参数`ModelMap model`为`sayHello(ModelMap model)`来给请求增加一个model，在处理请求的过程中，根据需要为model通过`addAttribute()`方法来增加一些值(model 是一个map，key是字符串，value是一个对象)，而jsp提供了一些标签，可以通过这些标签直接访问请求中附加的model的一些值并显示在网页中。

不过，这里不会详细提jsp的一些特色标签，而是基本不会使用html中不包含的标签进行开发以降低学习成本，下面，将展示如何反馈一些信息以相应客户端的请求

对于一个正常的请求，我们通常会做出两种处理，第一种是这个请求请求的是某种服务端的数据或者资源，例如用户信息、商品信息，或者是想要下载一个文件；第二种是向服务端输送一些数据，如用户的注册，商品的上架等等，当然也可能是校验一些数据，如登录、校验验证码之类的这里也归为第二种。

那么对于以上提到的第一种情况，服务端做的响应应返回相应的数据，如用户列表、商品列表；对于第二种情况，服务端相应返回状态码，成功状态、失败状态或者其他预定义的一些状态。那么客户端在拿到这些相应的数据之后，就可以做相应的处理。

**先谈第一种，返回请求的数据**

假定一个情景，我们需要返回一个商品列表的数据

在`cn.nuaa.tomax.entity`目录下添加一个java类`GoodEntity`(在entity包上右键new或者alt+insert 选择java class),命名为`GoodEntity`,添加如下代码

``` Java
package cn.nuaa.tomax.entity;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/4/24 0:10
 */
public class GoodEntity {
    private long id;
    private String name;
    private float price;

    public GoodEntity() {}

    public GoodEntity(long id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
```

这是一个POJO（plain old java object）即只有私有化成员变量并且为每一个成员变量定义一组get，set方法，具有严格的命名规范,本身的意义是抽象了一个商品类。

下面我们需要通过请求获取一个商品列表数据，在`cn.nuaa.tomax.controller.HelloWorldController`中添加一个新的方法，暂且命名为`getGoodsList()`，同时给它一个访问路径为`/getGoodList`

``` Java
@RequestMapping(value = "/getGoodList",method = RequestMethod.GET)
public @ResponseBody List<GoodEntity> getGoodList(){
    List<GoodEntity> goodEntities = new ArrayList<>();
    goodEntities.add(new GoodEntity(1,"iphone",5000));
    goodEntities.add(new GoodEntity(2,"ipad",4000));
    goodEntities.add(new GoodEntity(3,"macpro",120000));
    return goodEntities;
}
```

可以发现，这里方法的返回值不再是一个`String`,而是一个商品类的list，不难理解，因为想要获取的数据就是一个商品列表信息，但是为了和之前讲的将返回值映射到一个view上去做区别，这里在该方法的返回值上增加了一个`@ResponseBody`注解，通过该注解，加上在`WebConfig`中的配置（配置已添加，直接当成默认配置来用就好），系统会将返回值处理成一个`JSONArray`返回到前台以供相应的处理，同样，为了方便直接去访问这个接口，仍然将该方法申明为GET请求访问。

重启服务器，在浏览器地址栏中输入`localhost:8080/getGoodList`，结果如下

![](https://tomax.xin/img/blog/cd/40.png)

**再谈第二种**

其实原理上是一样的，只不过需要实现定义一个抽象返回值的类来返回处理结果，所以，同样在`cn.nuaa.tomax.entity`中添加一个java类:`ResultCause`,类的内容如下

``` Java
package cn.nuaa.tomax.entity;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/4/24 23:43
 */
public class ResultCause {

    public static final String SUCCESS_CODE = "200";
    public static final String FAIL_CODE = "400";

    private String code;
    private String desc;

    public ResultCause() {}

    public ResultCause(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

```

该类仅包含了两个成员，code(状态码)，desc(状态描述)，以及两个字符串常量，一个`SUCCESS_CODE`,`FAIL_CODE`，分别表示成功与失败两种状态，当然也会有其他的状态，不过目前这两种已经够用了，当需要时可以再行扩展。如果是需要加以规范，或许会在设计时便确定专门的由常量构成的类来管理肯能出现的code和desc，这里简化这方面的处理，desc会直接在需要的时候赋值。

下面模拟一个验证身份的请求，通过前端传来一个token，如果token为1的话，验证成功，否则，验证失败，为了实现这个功能，在`cn.nuaa.tomax.controller`中添加一个新的方法`checkToken()`，其访问地址为`localhost:8080/checkToken`

``` Java

@RequestMapping(value = "/checkToken", method = RequestMethod.GET)
public @ResponseBody
ResultCause checkToken(String token){
    // 这里的1因为是只会用在这一个地方，所以没有专门设置一个状态来描述
    if (token.equals("1")){
        return new ResultCause(ResultCause.SUCCESS_CODE,"验证成功");
    }else {
        return new ResultCause(ResultCause.FAIL_CODE,"验证失败");
    }
}

```

在这个新添加的方法中，返回了`ResultCause`这个类的对象，同时多了一个参数`token`，在方法中对于`token`做了具体的判断，然后返回预定义的状态即相应的描述。显然`token`的值是由请求的参数而来的，在GET方法做的请求中，可以通过在请求的URL后用?name=value的形式来增加参数，这里即`localhost:8080/checkToken?token=1`或者token后跟上其他的数字

重启服务器，在浏览器地址栏一次输入`localhost:8080/checkToken?token=1`，`localhost:8080/checkToken?token=2`，结果如下

![](https://tomax.xin/img/blog/cd/41.png)

![](https://tomax.xin/img/blog/cd/42.png)

结果如设定的是一样的。

至此，Hello world算是完成了

## 小结

这一篇博客讲述了如何建立一个spring的项目，并且完成HelloWorld程序，部分地方讲得会比较冗余，主要是为了加深从未使用过IDEA或者类似IDE得同学对于开发环境得印象，部分地方会显得有些说不清楚，是因为对于一个成熟的应用框架而言，即便很小的切入点都会牵扯出大量的知识点，而知识点本身又会衍生出一些知识点，所以很难通过几篇博客将这些知识梳理清楚，像梳理清楚的话，那就不停的google或者百度吧，需要有一定的耐心，当然，即便不那么懂也是没关系的，继续进行下去，在多个例子中，总会有很多的收获。

在HelloWorld中，只是提到了很简单的几个方法，但其实这些比较简单的形式足以支撑许多功能的controller开发了，其实，有想像力的同学已经可以使用这些形式做出许多很有用的表达，在下一篇博客中，将会通过一些情景来描述web开发

[下一篇：讲一个和Java web项目中mvc有关的情景](https://github.com/XingToMax/DesignPatternDemo/blob/master/blogs/mvc.md)

[回到目录](https://github.com/XingToMax/DesignPatternDemo/tree/master/blogs)

[问题跟踪和更新说明](https://github.com/XingToMax/DesignPatternDemo/blob/master/blogs/%E9%97%AE%E9%A2%98%E8%B7%9F%E8%B8%AA%E5%92%8C%E6%9B%B4%E6%96%B0%E8%AF%B4%E6%98%8E.md)

<br>

> 如果有帮助的话，来颗star吧