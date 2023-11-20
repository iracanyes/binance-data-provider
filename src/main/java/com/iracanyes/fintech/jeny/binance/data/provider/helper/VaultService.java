package com.iracanyes.fintech.jeny.binance.data.provider.helper;

import com.iracanyes.fintech.jeny.core.model.Account;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultKeyValueOperationsSupport.KeyValueBackend;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;


@Service
public class VaultService {

  private VaultTemplate vaultTemplate;


  public VaultService(VaultTemplate pVaultTemplate){
    this.vaultTemplate = pVaultTemplate;
  }


  public VaultResponse getSecurityInfo(Account pAccount){
    return   vaultTemplate.opsForKeyValue("jeny", KeyValueBackend.KV_2).get("bnc/" + pAccount.getAccountId());
  }
}
