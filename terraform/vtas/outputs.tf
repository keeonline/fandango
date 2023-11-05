output "vtas_host_ip_addr" {
  value = data.azurerm_virtual_machine.vtas_vm.public_ip_address
}