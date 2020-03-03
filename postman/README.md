# POSTMAN
postman作为一款接口测试工具，已经有十多年的时间了。通过不断的迭代开发，功能已经很全面了。
我们介绍了它的[简单使用](lesson2)，发送post请求中的[不同场景](lesson3)：提交表单、json数据的请求发送、如何设置cookie等等。
接着，我们介绍了postman的[环境变量的管理](lesson4)，其主要目的就是针对一个接口有多套环境的情况。这里的环境可以是变化的域名、uri路径、请求参数。都可以用{{}}表达式去表示。
再接着，介绍了[断言](lesson5)的使用。postman的断言语法是JavaScript，只要是知道一点js语法的，基本上就可以看懂和写一小段断言的代码了。当然，在官网上，postman给出了断言库[ChaiJS](https://www.chaijs.com/api/assert/)如何使用的详细说明文档。比较简单的可以用推荐的代码片段，比较复杂的就需要去查阅文档了。
后面就是我们的重头戏Collection了。这里分成了两讲：一个是[带断言的运行Collection](lesson6)，另一个是[带数据文件的运行Collection](lesson7)。这两种方式请大家一定掌握，对今后的实际测试会很有帮助。
其实，postman还有许多的功能，比方mock服务，请求录制等。这里就不一一介绍了。感兴趣的可以自学下。
另外，最近出了一款比较火的类postman产品，叫做[postwoman](https://postwoman.io/)。前端是用vue写的，据说是高颜值的接口测试工具。大家有兴趣可以体验下。