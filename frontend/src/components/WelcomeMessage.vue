<template>
  <div id="main">
    <h1>{{msg}}</h1>
    <p>Click on the Top Movies navigation link to view the top 250 movies, based on IMDb.com.</p>
  </div>
</template>

<script>
export default {
    name: 'WelcomeMessage',
    props: {
        msg: String
    }
}
</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>