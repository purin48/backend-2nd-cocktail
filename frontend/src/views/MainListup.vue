<template>
  <div>
    <h2>Todo Listdd</h2>
    <ul>
      <li class = "list" v-for="(item, index) in DUMMY_LIST_DATA" :key="index">
        <span>{{ item.name }}</span>
        <span>{{ item.description }}</span>
        <span>{{ item.alchol }}</span>
      </li>
    </ul>
    <button @click="addTodo">추가</button>
  </div>
</template>

<script setup>
  const DUMMY_LIST_DATA = [
  {
        "id": 1,
        "name": "보드카",
        "description": "러시아에서 주로 마시는 대표 증류주이다.",
        "alchol": "40도",
        "imgLink": null,
        "cocktailType": {
            "id": 1,
            "name": "증류주"
        }
    },
    {
        "id": 2,
        "name": "하이볼",
        "description": "길쭉한 잔에 얼음을 채우고 위스키를 넣은 다음 탄산수를 부은 술",
        "alchol": "10도",
        "imgLink": null,
        "cocktailType": {
            "id": 1,
            "name": "증류주"
        }
    }
  ];

  const addTodo = () => {
    if (this.newTodo.trim() !== '') {
        console.log("나 나옴");
        this.todos.push(this.newTodo);
        this.newTodo = '';
      }
  }
</script>

<style scoped>
  
</style>