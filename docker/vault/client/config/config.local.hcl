#api_addr = "https://127.0.0.1:8200"
#cluster_addr = "https://127.0.0.1:8201"
ui = true
disable_mlock = true
pid_file = "./pidfile"

vault {
  address = "https://vault-server:8200"
}

auto_auth {
  method {
    type = "approle"

    config = {
      role_id_file_path = "/vault/jeny-role_id"
      secret_id_file_path = "/vault/jeny-secret_id"
      remove_secret_id_file_after_reading = false
    }
  }

  sink {
    type = "file"
    config = {
      path = "/vault/token"
    }
  }
}


listener "tcp" {
  address       = "0.0.0.0:8200"
  tls_cert_file = "/vault/tls/vault.crt"
  tls_key_file  = "/vault/tls/vault.key"
  #tls_require_and_verify_client_cert = true
  #tls_client_ca_file = "/vault/tls/ca.crt"  # Chemin vers le certificat de l'autorité de certification
}


#storage "raft" {
#  path = "/vault/data"
#  node_id = "node1"
#}

log_level = "info"

#initialized = "true"