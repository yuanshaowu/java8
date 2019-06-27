package com.huangzhikai.Lambda;

import com.huangzhikai.pojo.Student;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 自定义排序规则
 * Created by huang on 2018/9/13.
 */
public class LambdaDemo12ByCollect {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>() {
            {
                add(new Student("北京", "依依", 17));
                add(new Student("上海", "尔尔", 18));
                add(new Student("广州", "散散", 19));
                add(new Student("深圳", "思思", 20));
                add(new Student("杭州", "呜呜", 21));
                add(new Student("杭州", "柳柳", 22));
            }
        };

        // 转list
        List<String> nameList = list.stream().map(Student::getName).collect(Collectors.toList());
        System.out.println(nameList);

        // 转set
        Set<String> addressSet = list.stream().map(Student::getAddress).collect(Collectors.toSet());
        System.out.println(addressSet);

        // 转map，需要指定key和value，Function.identity()表示当前的Emp对象本身
        Map<String, Student> nameMap = list.stream().collect(Collectors.toMap(Student::getName, Function.identity()));
        System.out.println(nameMap);

        // 计算元素中的个数
        Long count = list.stream().collect(Collectors.counting());
        System.out.println(count);

        // 计算元素中数据求和 summingInt summingLong，summingDouble
        Integer sumAges = list.stream().collect(Collectors.summingInt(Student::getAge));
        System.out.println(sumAges);

        // 计算元素中数据平均值 averagingInt,averagingLong,averagingDouble
        Double aveAges = list.stream().collect(Collectors.averagingInt(Student::getAge));
        System.out.println(aveAges);

        // 综合处理: 求最大值，最小值，平均值，求和操作 summarizingInt，summarizingLong,summarizingDouble
        IntSummaryStatistics intSummary = list.stream().collect(Collectors.summarizingInt(Student::getAge));

        // 平均值
        System.out.println(intSummary.getAverage());
        // 最大值
        System.out.println(intSummary.getMax());
        // 最小值
        System.out.println(intSummary.getMin());
        // 求和
        System.out.println(intSummary.getSum());
        // 连接字符串
        String strName = list.stream().map(emp -> emp.getName()).collect(Collectors.joining());
        System.out.println(strName);
        // 连接字符串,中间分隔符
        String strName1 = list.stream().map(emp -> emp.getName()).collect(Collectors.joining("-中间分隔符-"));
        System.out.println(strName1);
        // 连接字符串,前缀，后缀和中间分隔符
        String strName2 = list.stream().map(emp -> emp.getName()).collect(Collectors.joining("-中间分隔符-", "（", "）"));
        System.out.println(strName2);
        // maxBy 按照比较器中的比较结果刷选 最大值
        Optional<Integer> maxAge = list.stream().map(emp -> emp.getAge()).collect(Collectors.maxBy(Integer::max));
        System.out.println(maxAge);
        // minBy 按照比较器中的比较结果刷选 最小值
        Optional<Integer> minAge = list.stream().map(emp -> emp.getAge()).collect(Collectors.minBy(Integer::min));
        System.out.println(minAge);
        // 归约操作
        Optional<Integer> sumAge = list.stream().map(emp -> emp.getAge()).collect(Collectors.reducing((x, y) -> x + y));
        System.out.println(sumAge);
        // 分操作 groupingBy 根据地址，把原list进行分组
        Map<String, List<Student>> mapGroup = list.stream().collect(Collectors.groupingBy(Student::getAddress));
        System.out.println(mapGroup);
        // partitioningBy 分区操作 需要根据类型指定判断分区
        Map<Boolean, List<Integer>> partitioningMap = list.stream().map(emp -> emp.getAge()).collect(Collectors.partitioningBy(emp -> emp > 20));
        System.out.println(partitioningMap);
    }
}
