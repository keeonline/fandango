terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "~>2.0"
    }
  }
  backend "azurerm" {
      resource_group_name  = "keeonline-tfstate"
      storage_account_name = "tfstate161123"
      container_name       = "tfstate"
      key                  = "app.tfstate"
  }

}

provider "azurerm" {
  features {}
}

data "azurerm_linux_virtual_machine" "vtas_vm" {
  name                 = "keeonline-vtas-vm"
}