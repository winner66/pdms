select * from pd_model where pd_class_id is  null

select * from pd_model where order_rule is  null

select count(1) from pd_info where pd_model_id in (
    select id from pd_model where order_rule is  null)

select * from pd_info where pd_model_id is null

select DISTINCT(size) from pd_info where size not in(
    select code from pd_param where type = '封装及外形尺寸'
)

select order_rule, order_rule_url from pd_model group by order_rule, order_rule_url

select * from pd_info where (capacity_min is not null and capacity_min_idx is null) || (capacity_max is not null and capacity_max_idx is null)
group by capacity_min_idx, capacity_max_idx

select DISTINCT(temperature) from pd_info where temperature not in(
    select code from pd_param where type = '温度特性/系数'
)

select DISTINCT(std) from pd_info where std not in(
    select code from pd_param where type = '执行标准'
)