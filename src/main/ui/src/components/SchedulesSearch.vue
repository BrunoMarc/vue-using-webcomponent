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
                                @change="setServices"
                                ></b-form-select>
                    </div>
                </div>
                <div class="col-md-10">
                    <div class="form-group">
                        <label htmlFor="servico">Serviço</label>
                            <b-form-select
                                v-model="servico"
                                :options="optionsServico"
                                class="mb-3"
                                value-field="value"
                                text-field="value.name"
                                disabled-field="notEnabled"
                                name="servico"
                                @change="getSchedules()"
                                ></b-form-select>
                    </div>
                </div>
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
import { getEstablishment, getSchedules } from '../services/EncaixeService'


export default {
  name: 'SchedulesSearch',
  data() {
      return {
        optionsEstabelecimento: [],
        estabelecimento: '', // Array reference
        categoria: '', // Array reference
        servico: '', // Array reference
        agenda: '', // Array reference
        convenio: '',
        optionsCategoria: [],
        optionsServico: [],
        optionsAgenda: [],
        componentFilterData: null,
        componentFilterSchedule: null,
        paymentTypes: {
            agreement: 3
        },
        payment: ''
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
        const establishment = this.estabelecimento.establishment;
        this.convenio = establishment.exclusiveAgreementId;
        this.payment = this.categoria.value ? this.categoria.value.id : this.paymentTypes.agreement;
        getSchedules(establishment.id, this.categoria.id, this.servico.id, this.payment, this.convenio).then(response => {
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
    setServices(data) {
        this.optionsServico = data.services.map((service) => {
            return { 
                value: service
            }
        });
    },
    generateEncaixeSchedule() {
        this.componentFilterData = `{
            "offers": {
                "category": {
                    "id": "${this.categoria.id}",
                    "name": "${this.categoria.label}"
                },
                "service": {
                    "id": "${this.servico.id}",
                    "name": "${this.servico.name}"
                },
                "value": "${this.payment}",
                "agreement": "${this.convenio}"
            }
        }`
        this.componentFilterSchedule = `{
            "id": "${this.agenda.schedule.id}",
            "name": "${this.agenda.schedule.title}",
            "imageUrl": "${this.agenda.schedule.imageUrl}"
        }`
    }
  },
  mounted () {
    this.getEstablishment('ciretranaeroporto');
  }
}
</script>