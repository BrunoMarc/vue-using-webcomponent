<template>
  <div class="container">
    <div class="d-flex flex-column align-items-center">
        <h2>AGENDAR ATENDIMENTO</h2>
            <form class="col-10 d-flex flex-column align-items-center">
                <div class="col-md-10">
                    <div class="form-group">
                        <label htmlFor="exampleInputEmail1">Estabelecimento</label>
                            <b-form-select
                                v-model="estabelecimento"
                                :options="optionsEstabelecimento"
                                class="mb-3"
                                value-field="value"
                                text-field="value.establishment.name"
                                disabled-field="notEnabled"
                                name="estabelecimento"
                                @change="setCategories"
                                ></b-form-select>
                    </div>
                </div>
                <div class="col-md-10">
                    <div class="form-group">
                        <label htmlFor="categoria">Categoria</label>
                            <b-form-select
                                v-model="categoria"
                                :options="optionsCategoria"
                                class="mb-3"
                                value-field="value"
                                text-field="value.label"
                                disabled-field="notEnabled"
                                name="categoria"
                                @change="getSchedules()"
                                ></b-form-select>
                    </div>
                </div>
                <!-- <div class="col-md-10">
                    <div class="form-group">
                        <label htmlFor="servico">Serviço</label>
                            <b-form-select
                                v-model="servico"
                                :options="optionsServico"
                                class="mb-3"
                                value-field="value"
                                text-field="name"
                                disabled-field="notEnabled"
                                name="servico"
                                ></b-form-select>
                    </div>
                </div> -->
                <div class="col-md-10">
                    <div class="form-group">
                        <label htmlFor="agenda">Agenda</label>
                            <b-form-select
                                v-model="agenda"
                                :options="optionsAgenda"
                                class="mb-3"
                                value-field="value"
                                text-field="value.schedule.title"
                                disabled-field="notEnabled"
                                name="agenda"
                                @change="generateEncaixeSchedule()"
                                ></b-form-select>
                    </div>
                </div>
                <encaixe-schedule v-if="componentFilterData"
                    color="#00b7f0"
                    v-bind:data=componentFilterData
                    v-bind:schedule=componentFilterSchedule>
                </encaixe-schedule>
            </form>
    </div>
    </div>
</template>

<script>
import { BFormSelect } from 'bootstrap-vue'
import { getEstablishment, createUser, getSchedules } from '../services/UserService'

export default {
  name: 'SchedulesSearch',
  data() {
      return {
        optionsEstabelecimento: [],
        estabelecimento: '', // Array reference
        categoria: '', // Array reference
        servico: '', // Array reference
        agenda: '', // Array reference
        optionsCategoria: [],
        optionsServico: [
          { value: 'a', name: 'This is First option' },
          { value: 'b', name: 'Default Selected Option' },
          { value: 'c', name: 'This is another option' },
          { value: 'd', name: 'This one is disabled' },
          { value: 'e', name: 'This is option e' },
          { value: 'f', name: 'This is option f' },
          { value: 'g', name: 'This is option g' }
        ],
        optionsAgenda: [],
        componentFilterData: null,
        componentFilterSchedule: null
      }
  },
  components: {
        'b-form-select': BFormSelect
    },
  methods: {
    getEstablishment(name) {
      getEstablishment(name).then(response => {
        console.log(response)
        this.optionsEstabelecimento = [{value: response}]
      })
    },
    getSchedules() {
        const establishmentId = this.estabelecimento.establishment.id
        getSchedules(establishmentId, this.categoria.id, this.categoria.value.id ).then(response => {
            console.log(response)
            this.optionsAgenda = response.map((schedule) => {
                return { 
                    value: schedule
                }
            });
        })
    },
    setCategories(data) {
        this.optionsCategoria = data.reasonOptions.map((category) => {
            return { 
                value: category
            }
        });
    },
    generateEncaixeSchedule() {
        this.componentFilterData = `{
            "offers": {
                "serviceId": ${this.agenda.service.id},
                "value": ${this.categoria.value.id}
            }
        }`
        this.componentFilterSchedule = `{"id": ${this.agenda.schedule.id}}`
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
    this.getEstablishment('ciasc');
  }
}
</script>