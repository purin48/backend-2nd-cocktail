<template>
  <div>
      <h1>칵테일 수정</h1>
      <form v-on:submit.prevent="submitForm">
          <h3>당신이 사랑하는 칵테일을 수정해 주세요</h3>
          <div id="file_input">
              <!-- <input type="file" accept="image/*" /><br> -->
          </div>
          <span>
              이름 :
              <input id="cName" type="text" placeholder="칵테일 이름" v-model="insertData.name"><br>
          </span>

          <span>
              설명 : <input id="cDesc" type="text" placeholder="술에 대해 설명해주세요 :)" v-model ="insertData.description"><br>
          </span>


          <span>
              도수 : <input id="cAl" type="text" placeholder="도수는 몇 도?" v-model ="insertData.alchol"><br>
          </span>


          <span>
              타입 : 
              {{ insertData.cocktailTypeId }}
              <!-- <input id="cType" type="text" v-model ="insertData.cocktailTypeId"> -->
              <!-- <select id="cType" v-model ="cType">
                <option v-bind:class = "cocktailType" v-for="(item, index) in listData" :key="index" :value="item.id">
                  {{ item.name }}
                </option>
              </select> -->
              <br>
          </span>

          <button type="submit">수정</button>
      </form>
  </div>
</template>

<script setup>
import axios from "axios";
import { watchEffect, onBeforeMount, ref, computed } from "vue";
import router from "../router";

const listData = ref([]);
let pathUrl;
const cName = ref("");
const cDesc = ref("");
const cAl = ref("");
const cType = ref("");

// GET
const insertData = computed(() => {
  return {
    name : listData.value[0].name,
    description : listData.value[0].description,
    alchol : listData.value[0].alchol,
    cocktailTypeId: listData.value[0].cocktailType.name
  }
});

// POST
const formData = computed(() => {
  return {
    name : insertData.value.name,
    description : insertData.value.description,
    alchol : insertData.value.alchol,
    cocktailTypeId: insertData.value.cocktailTypeId
  }
});

watchEffect(() => {
  pathUrl = window.location.pathname;

  axios.get(`/cocktail${pathUrl}`).then(res => {
    listData.value.push(res.data);
  });
});

const submitForm = () => {
  axios.post(`/cocktail${pathUrl}`, formData.value).then((res) => {
    console.log(res.data);
    alert("수정되었습니다!!!!!");
    window.location.href = "/list";
  })
};


const addCocktail = ()=>{
  router.push({path:"/add"})
}
</script>

<style scoped>
li{
   list-style-type: none;
}

ul{
  margin : 3rem;
}

</style>