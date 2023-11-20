/**
 * Description: All signed Endpoints
 * SIGNED (TRADE, USER_DATA, AND MARGIN) Endpoint security
 * <p>
 *     SIGNED endpoints require an additional parameter, signature, to be sent in the query string or request body.
 *     Endpoints use HMAC SHA256 signatures. The HMAC SHA256 signature is a keyed HMAC SHA256 operation. Use your secretKey as the key and totalParams as the value for the HMAC operation.
 *     The signature is not case sensitive.
 *     totalParams is defined as the query string concatenated with the request body.
 * <p>
 * Timing security
 * <p>
 *     A SIGNED endpoint also requires a parameter, timestamp, to be sent which should be the millisecond timestamp of when the request was created and sent.
 *     An additional parameter, recvWindow, may be sent to specify the number of milliseconds after timestamp the request is valid for. If recvWindow is not sent, it defaults to 5000.
 */
package com.iracanyes.fintech.jeny.binance.data.provider.helper;

import com.iracanyes.fintech.jeny.core.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultKeyValueOperationsSupport;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
@Slf4j
public class HmacSha256Signature {
  private final VaultTemplate vaultTemplate;

  public HmacSha256Signature(VaultTemplate pVaultTemplate){
    this.vaultTemplate  = pVaultTemplate;

  }

  public String encryptData(String data, Account account){
    String signature = "";
    String secretKey =  "";

    VaultResponse response = vaultTemplate.opsForKeyValue("jeny", VaultKeyValueOperationsSupport.KeyValueBackend.KV_2).get("bnc/" + account.getAccountId());
    if(response == null){
      log.error("Vault Key/Value operator returns null.");
    }else{
      try{
        secretKey = (String) response.getData().get("security.secretKey");

        // Créez un objet SecretKeySpec en utilisant la clé secrète
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
        try{
          // Créez un objet Mac avec l'algorithme HmacSHA256
          Mac mac = Mac.getInstance("HmacSHA256");

          // Initialisez l'objet Mac avec la clé secrète
          mac.init(keySpec);

          // Calculez la signature HMAC pour le message donné
          byte[] hmac = mac.doFinal(data.getBytes());

          // Encodez la signature HMAC en base64
          signature = Base64.getEncoder().encodeToString(hmac);
        }catch(NoSuchAlgorithmException e) {
          log.error("Unknown algorythm provided", e);
        }catch (InvalidKeyException e){
          log.error("Invalid key provided", e);
        }
      }catch (NullPointerException e){
        log.error("Vault response get data throw NullPointerException", e);
      }
    }

    return signature;
  }
}
