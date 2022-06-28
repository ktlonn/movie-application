import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    movies: []
  },
  mutations: {
    SET_MOVIES(state, data) {
      state.movies = data;
    }
  },
  actions: {
  },
  modules: {
  }
})
