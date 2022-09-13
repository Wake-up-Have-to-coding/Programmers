## 2주차 - 해시(레벨 3)

***

<br>

### :pushpin: 해시 - 레벨 3

- 베스트앨범

<br>



### :pushpin: java HashMap 순회 방법

```java
HashMap<String, String> hashMap = new HashMap<String, String>();
```

<br>

1. 향상된 for문을 통한 keySet, valueSet 순회

```java
List<String> keyList = new ArrayList(hashMap.keySet());

for(String str : keyList){
    System.out.println(str);
}
```

```java
List<String> valueList = new ArrayList(hashMap.values());

for(String str : valueList){
    System.out.println(str);
}
```

<br>

2. Entry를 이용한 순회

```java
for(HashMap<String, String> entry : hashMap.entrySet()){
    System.out.print("key : " + entry.getKey());
    System.out.println("value : " + entry.getValue());
}
```

<br>

3. forEach를 이용한 순회

```java
hashMap.forEach((key, value) -> {
    System.out.println("key : " + key + ", " + "value : "+value);
});
```

