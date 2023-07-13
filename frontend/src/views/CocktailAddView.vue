<template>
  <div>
      <h1>칵테일 추가</h1>
      <form>
          <h3>당신이 사랑하는 칵테일을 추가해 주세요</h3>
          <div id="file_input">
              <input type="file" accept="image/*" /><br>
          </div>
          <span>
              이름 :
              <input type="text" name="c_name" placeholder="칵테일 이름"><br>
          </span>

          <span>
              설명 : <input type="text" name="" placeholder="술에 대해 설명해주세요 :)"><br>
          </span>


          <span>
              도수 : <input type="text" name="" placeholder="도수는 몇 도?"><br>
          </span>


          <span>
              타입 : <select form=form_id></select><br>
          </span>

          <button @click="submitBtn()">저장</button>
      </form>
  </div>
</template>

<script>
export default {
  setup() {


      return {}
  }
}
</script>

<style>
input {
  display: inline-block;
  margin: 1rem;
}

h1 {
  margin-bottom: 2rem;
}

#file_input {
  border: dashed 2px;
}
</style>