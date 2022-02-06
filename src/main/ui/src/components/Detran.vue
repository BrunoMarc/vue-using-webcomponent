<template>
  <div class="hello">
    <Header />
    <div class="container mrgnbtm">
          <div class="row">
            <div class="col-md-12">
                <SchedulesSearch @createUser="userCreate($event)" />
            </div>
          </div>
    </div>
  </div>
</template>

<script>
import Header from './Header.vue'
import SchedulesSearch from './SchedulesSearch.vue'
import { getEstablishment, createUser } from '../services/UserService'

export default {
  name: 'Detran',
  components: {
    Header,
    SchedulesSearch
  },
  data() {
      return {
          establishment: [],
          numberOfUsers: 0
      }
  },
  methods: {
    getEstablishment() {
      getEstablishment().then(response => {
        console.log(response)
        this.establishment = [response]
        this.numberOfUsers = this.users.length
      })
    },
    userCreate(data) {
      console.log('data:::', data)
      data.id = this.numberOfUsers + 1
      createUser(data).then(response => {
        console.log(response);
        this.getEstablishment();
      });
    }
  },
  mounted () {
    this.getEstablishment();
  }
}
</script>