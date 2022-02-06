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
                                text-field="name"
                                disabled-field="notEnabled"
                                name="estabelecimento"
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
                                text-field="name"
                                disabled-field="notEnabled"
                                name="categoria"
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
                                text-field="name"
                                disabled-field="notEnabled"
                                name="servico"
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
                                text-field="name"
                                disabled-field="notEnabled"
                                name="agenda"
                                ></b-form-select>
                    </div>
                </div>
                <encaixe-schedule v-if="agenda"
                    color="#00b7f0"
                    data='{
                        "offers": {
                        "serviceId": "24",
                        "value": "2"
                        }
                    }'
                    schedule='{"id": "13"}'>
                </encaixe-schedule>
            </form>
    </div>
    </div>
</template>

<script>
import { BFormSelect } from 'bootstrap-vue'

export default {
  name: 'SchedulesSearch',
  data() {
      return {
        estabelecimento: '', // Array reference
        categoria: '', // Array reference
        servico: '', // Array reference
        agenda: '', // Array reference
        optionsEstabelecimento: [
          { value: 'a', name: 'This is First option' },
          { value: 'b', name: 'Default Selected Option' },
          { value: 'c', name: 'This is another option' },
          { value: 'd', name: 'This one is disabled' },
          { value: 'e', name: 'This is option e' },
          { value: 'f', name: 'This is option f' },
          { value: 'g', name: 'This is option g' }
        ],
        optionsCategoria: [
          { value: 'a', name: 'This is First option' },
          { value: 'b', name: 'Default Selected Option' },
          { value: 'c', name: 'This is another option' },
          { value: 'd', name: 'This one is disabled' },
          { value: 'e', name: 'This is option e' },
          { value: 'f', name: 'This is option f' },
          { value: 'g', name: 'This is option g' }
        ],
        optionsServico: [
          { value: 'a', name: 'This is First option' },
          { value: 'b', name: 'Default Selected Option' },
          { value: 'c', name: 'This is another option' },
          { value: 'd', name: 'This one is disabled' },
          { value: 'e', name: 'This is option e' },
          { value: 'f', name: 'This is option f' },
          { value: 'g', name: 'This is option g' }
        ],
        optionsAgenda: [
          { value: 'a', name: 'This is First option' },
          { value: 'b', name: 'Default Selected Option' },
          { value: 'c', name: 'This is another option' },
          { value: 'd', name: 'This one is disabled' },
          { value: 'e', name: 'This is option e' },
          { value: 'f', name: 'This is option f' },
          { value: 'g', name: 'This is option g' }
        ]
      }
  },
  components: {
        'b-form-select': BFormSelect
    },
  methods: {
      createUser() {
          console.log(this.firstName)
          const payload = {
              firstName: this.firstName,
              lastName: this.lastName,
              email: this.email
          }
          this.$emit('createUser', payload)
          this.clearForm();
      },
      clearForm() {
          this.firstName = "";
          this.lastName = "";
          this.email = "";
      }
  }
}
</script>