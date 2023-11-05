output "app_host_ip_addr" {
  value = azurerm_linux_virtual_machine.app_vm.public_ip_address
}