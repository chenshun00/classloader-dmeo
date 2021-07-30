### APM 的实现思路

所有 agent 探针都是一个模子刻出来的，不论是 pinpoint，或者是 skywalking，还是 arthas，
他们的核心思路就是 javaagent 引入主 Agent 类， 自定义 classLoader 加载自定义路径 lib 目录下的 jar 包，
通过一定的机制来进行处理引入字节码。 
比较核心有 SPI，ClassLoader 的理解。
skywalking 因为使用的是 bytebuddy，在这方面简化了不少，相比 pinpoint 的代码，skywalking 的代码更简单，
当然功能相比 pinpoint 更弱。 这么说并不是贬低 skywalking，
我认为 agent 探针的难度从来都不在于 agent 怎么写，而在于存储的数据如何组织，如何展现到前端。
