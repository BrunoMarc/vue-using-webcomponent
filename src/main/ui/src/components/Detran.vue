<template>
  <div class="hello">
    <Header />
    <div class="container mrgnbtm">
          <div class="row">
            <div class="col-md-12">
                <SchedulesSearch />
            </div>
          </div>
    </div>
  </div>
</template>

<script>
import Header from './Header.vue'
import SchedulesSearch from './SchedulesSearch.vue'
import { getEstablishment } from '../services/EncaixeService'

export default {
  name: 'Detran',
  components: {
    Header,
    SchedulesSearch
  },
  data() {
      return {
          establishment: []
      }
  },
  methods: {
    getEstablishment() {
      getEstablishment().then(response => {
        console.log(response)
        this.establishment = [response]
        this.numberOfUsers = this.users.length
      })
    }
  },
  mounted () {
    this.getEstablishment();
  }
}
</script>