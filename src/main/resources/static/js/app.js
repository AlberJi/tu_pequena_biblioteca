
function filter_by_name() {
  $.ajax({
    type: "get",
    url: "/empleado/list/filter/",
    data: {
      nombre: $('#nombre').val()
    },
    success: function (htmlRecibido) {
      $('#lista-empleados').html(htmlRecibido);
    },
    error: function (e) {
      console.log(e);
    }
  });
}













