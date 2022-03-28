## 题目
欢迎来到"镶金玫瑰"！这是一家魔兽世界里的小商店，但地段超好。

老板叫艾利森，是个友善的人。我们出售的商品也都是高质量的。

但不妙的是，随着商品逐渐接近保质期，它们的质量也不断下滑。

我们用一个 IT 系统来更新库存信息。开发这个系统的程序员叫勒罗伊，他已经不在我们公司了。

现在，你的任务就是要在这个系统中添加新的特性，以便我们可以销售新的商品。

首先，简单介绍一下我们的系统：
- 所有商品都有一个`SellIn`值，这是商品的保质期，最好在这么多天之内卖掉
- 所有商品都有一个`Quality`值，代表商品的价值
- 每过一天，所有商品的`SellIn`值和`Quality`值都减 1

此外，有些特殊的商品还有自己的特性：
- 一旦过了保质期，`Quality`就以双倍的速度下滑
- 陈年干酪（Aged Brie）是一种特殊的商品，放得越久，价值反而越高
- 商品的价值永远不会小于 `0`，也永远不会超过 `50`
- 萨弗拉斯（Sulfuras）是一种传奇商品，没有保质期的概念，质量也不会下滑
- 后台门票（Backstage pass）和陈年干酪有相似之处
  - 越是接近演出日，随着`SellIn`值的增加，商品价值`Quality`值反而上升
  - 在演出前 `10` 天，价值每天上升 `2` 点；演出前 `5` 天，价值每天上升 `3` 点
  - 但一旦过了演出日，价值就马上变成 0

我们最近还签了一个供应商，给我们供应魔法召唤物品。这又需要升级我们的系统：
- 魔法召唤（Conjured）物品的贬值速度是普通物品的两倍

## 步骤

### 1. 理解需求 ✅
要有日拱一卒、长期作战的精神。  
在踏上重构的征程前，要摈弃毕其功于一役的急躁想法，每天做一点点修改，日积月累地就能形成可观的改善
### 2. 添加护城河-测试 ✅
添加足够的测试，确保功能被完全覆盖，代码覆盖率足够

这是重构的护城河，也是必需条件，能够保证我们所做的重构不会被原有系统造成破坏

### 3. 小步前进，徐徐图之 ✅
第一步先整理代码，解决明显的坏味道

### 4. 按图索骥，步步为营
