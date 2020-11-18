update pd_class set icon_url = '/files/images/pd-class/1-多层瓷介片式电容器.png' where name = '多层瓷介电容器';
update pd_class set icon_url = '/files/images/pd-class/2-单层芯片瓷介电容器.png' where name = '芯片电容器';
update pd_class set icon_url = '/files/images/pd-class/11-多芯组(支架)电容器-1.png' where name = '多芯组(支架)电容器';
update pd_class set icon_url = '/files/images/pd-class/6-穿心瓷介电容器.png' where name = '穿心瓷介电容器';
update pd_class set icon_url = '/files/images/pd-class/7-传信滤波器.png' where name = '穿心滤波器';
update pd_class set icon_url = '/files/images/pd-class/15-穿心接线端子.png' where name = '穿心接线端子';
update pd_class set icon_url = '/files/images/pd-class/12-三端瓷介电容器-1.png' where name = '三端电容器';
update pd_class set icon_url = '/files/images/pd-class/30-LTCC滤波器.png' where name = 'LTCC滤波器 功分器';
update pd_class set icon_url = '/files/images/pd-class/31-介质滤波器.png' where name = '介质滤波器';
update pd_class set icon_url = '/files/images/pd-class/32-陶瓷基片.png' where name = '陶瓷基片';
update pd_class set icon_url = '/files/images/pd-class/33-LTCC生瓷带.png' where name = 'LTCC生瓷带 MLCC瓷料';
update pd_class lev2 join pd_class lev3 set lev3.icon_url = lev2.icon_url where lev3.p_id = lev2.id and lev3.level = 3;

UPDATE pd_param pp
    JOIN pd_param_copy1 ppc ON pp.CODE = ppc.CODE
SET pp.NAME = ppc.NAME
WHERE
        pp.type = '温度特性/系数'
  AND ppc.type = '温度特性/系数';

UPDATE pd_param pp
    JOIN pd_param_copy1 ppc ON pp.CODE = ppc.CODE
SET pp.NAME = ppc.NAME
WHERE
        pp.type = '精度/容量偏差'
  AND ppc.type = '精度/容量偏差';


UPDATE pd_param pp
    JOIN pd_param_copy1 ppc ON pp.CODE = ppc.CODE
SET pp.NAME = ppc.NAME
WHERE
        pp.type = '引出端形式'
  AND ppc.type = '引出端形式';

update pd_model set order_rule_url = '/files/images/pd-rule/数据规则.png' where order_rule = '质量等级| |产品型号|-|封装及外形尺寸|-|温度特性/系数|-|电压|-|电容||精度/容量偏差|-|引出端形式|-|执行标准' and order_rule_url is null;
update pd_model set order_rule_url = '/files/images/pd-rule/单层芯片-1.png,/files/images/pd-rule/单层芯片-2.png' where order_rule = '质量等级| |产品型号|-|封装及外形尺寸|-|温度特性/系数|-|电压|-|电容||精度/容量偏差|-|引出端形式|-|电极材料代码|-|执行标准__质量等级| |产品型号|-|封装及外形尺寸|-|温度特性/系数|-|电压|-|电容||精度/容量偏差|-|电极材料代码|-|电容数量|-|执行标准' and order_rule_url is null;
update pd_model set order_rule_url = '/files/images/pd-rule/三端.png' where order_rule = '质量等级| |产品型号|-|封装及外形尺寸|-|温度特性/系数|-|电压|-|电容||精度/容量偏差|-|电流系列||端头结构||包装方式|-|执行标准' and order_rule_url is null;
update pd_model set order_rule_url = '/files/images/pd-rule/接线端子.png' where order_rule = '质量等级| |产品型号||电压|-|封装及外形尺寸|-|执行标准' and order_rule_url is null;
update pd_model set order_rule_url = '/files/images/pd-rule/滤波器.png' where order_rule = '质量等级| |产品型号|-|封装及外形尺寸||电压||电路形式|-|电容||精度/容量偏差|-|工作温度范围|-|引线材质||引线长短|-|执行标准' and order_rule_url is null;
update pd_model set order_rule_url = '/files/images/pd-rule/多芯组.png' where order_rule = '质量等级| |产品型号|-|封装及外形尺寸||引脚形状|-|温度特性/系数|-|电压|-|电容||精度/容量偏差' and order_rule_url is null;
update pd_model set order_rule_url = '/files/images/pd-rule/多层芯片.png' where order_rule = '质量等级| |产品型号|-|封装及外形尺寸|-|温度特性/系数|-|电压|-|电容||精度/容量偏差|-|电极材料代码|-|执行标准' and order_rule_url is null;
update pd_model set order_rule_url = '/files/images/pd-rule/穿心.png' where order_rule = '质量等级| |产品型号|-|封装及外形尺寸|-|温度特性/系数|-|电压|-|电容||精度/容量偏差|-|执行标准' and order_rule_url is null;

-- update pd_model set object_url = '/files/images/pd-model/穿心滤波器.jpg' where pd_class_id in(
-- select id from pd_class where p_id in(
--    select id from pd_class where name = '穿心滤波器'
-- ))

update pd_class lev3 join pd_class lev2 on lev3.p_id = lev2.id
set lev3.icon_url = lev2.icon_url
where lev3.LEVEL = 3 and (lev3.icon_url is null or lev3.icon_url = '');
