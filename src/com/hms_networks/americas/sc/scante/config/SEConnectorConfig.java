package com.hms_networks.americas.sc.scante.config;

import com.hms_networks.americas.sc.config.ConfigFile;
import com.hms_networks.americas.sc.json.JSONException;
import com.hms_networks.americas.sc.json.JSONObject;
import com.hms_networks.americas.sc.logging.Logger;
import com.hms_networks.americas.sc.scante.SEConnectorConsts;

/**
 * Configuration class containing configuration fields.
 *
 * @author HMS Networks, MU Americas Solution Center
 * @since 1.0
 */
public class SEConnectorConfig extends ConfigFile {

  /**
   * Get the configured connector log level from the configuration.
   *
   * @return connector log level
   * @throws JSONException if unable to get connector log level from configuration
   */
  public int getConnectorLogLevel() throws JSONException {
    return configurationObject.getInt(SEConnectorConsts.CONNECTOR_CONFIG_LOG_LEVEL_KEY);
  }

  /**
   * Get the configured Scante URL from the configuration.
   *
   * @return Scante URL
   * @throws JSONException if unable to get Scante URL address from configuration
   */
  public String getScanteURL() throws JSONException {
    String twIP = configurationObject.getString(SEConnectorConsts.CONNECTOR_CONFIG_SCANTE_URL_KEY);
    return twIP;
  }

  /**
   * Get the configured Scante url destination from the configuration.
   *
   * @return Scante destination
   * @throws JSONException if unable to get Scante destination from configuration
   */
  public String getScanteDest() throws JSONException {
    String twDest =
        configurationObject.getString(SEConnectorConsts.CONNECTOR_CONFIG_SCANTE_DEST_KEY);
    return twDest;
  }

  /**
   * Get the configured Scante token key from the configuration.
   *
   * @return Scante token key
   * @throws JSONException if unable to get Scante token key from configuration
   */
  public String getScanteToken() throws JSONException {
    String twToken =
        configurationObject.getString(SEConnectorConsts.CONNECTOR_CONFIG_SCANTE_TOKEN_KEY);
    return twToken;
  }

  /**
   * Get the configured Scante App ID from the configuration.
   *
   * @return Scante app id
   * @throws JSONException if unable to get Scante app id from configuration
   */
  public String getScanteAppID() throws JSONException {
    String twAppID =
        configurationObject.getString(SEConnectorConsts.CONNECTOR_CONFIG_SCANTE_APPID_KEY);
    return twAppID;
  }

  /**
   * Get the configured Scante Pull ID from the configuration.
   *
   * @return Scante pull id
   * @throws JSONException if unable to get Scante pull id from configuration
   */
  public String getScantePullID() throws JSONException {
    String twPullID =
        configurationObject.getString(SEConnectorConsts.CONNECTOR_CONFIG_SCANTE_PULLID_KEY);
    if (twPullID.equals(SEConnectorConsts.CONNECTOR_CONFIG_DEFAULT_SCANTE_PULLID)) {
      Logger.LOG_WARN(
          "The Scante Pull ID has not been configured. Please modify the configuration"
              + "to include a Scante app ID with all run time permissions enabled.");
    }
    return twPullID;
  }

  /**
   * Saves the configuration to the file system and catches any exceptions generated while saving.
   */
  void trySave() {
    try {
      save();
      Logger.LOG_DEBUG("Saved application configuration changes to file.");
    } catch (Exception e) {
      Logger.LOG_SERIOUS("Unable to save application configuration to file.");
      Logger.LOG_EXCEPTION(e);
    }
  }

  /**
   * Gets the file path for reading and saving the configuration to disk.
   *
   * @return configuration file path
   */
  public String getConfigFilePath() {
    return SEConnectorConsts.CONNECTOR_CONFIG_FOLDER
        + "/"
        + SEConnectorConsts.CONNECTOR_CONFIG_FILE_NAME;
  }

  /**
   * Gets the indent factor used when saving the configuration to file.
   *
   * @return JSON file indent factor
   */
  public int getJSONIndentFactor() {
    return SEConnectorConsts.CONNECTOR_CONFIG_JSON_INDENT_FACTOR;
  }

  /**
   * Creates a configuration JSON object containing fields and their default values.
   *
   * @return configuration object with defaults
   */
  public JSONObject getDefaultConfigurationObject() throws JSONException {
    JSONObject defaultConfigObject = new JSONObject();
    defaultConfigObject.put(
        SEConnectorConsts.CONNECTOR_CONFIG_LOG_LEVEL_KEY,
        SEConnectorConsts.CONNECTOR_CONFIG_DEFAULT_LOG_LEVEL);
    // defaultConfigObject.put(
    //    TWConnectorConsts.CONNECTOR_CONFIG_APP_KEY_KEY,
    //    TWConnectorConsts.CONNECTOR_CONFIG_DEFAULT_APP_KEY);
    defaultConfigObject.put(
        SEConnectorConsts.CONNECTOR_CONFIG_SCANTE_PULLID_KEY,
        SEConnectorConsts.CONNECTOR_CONFIG_DEFAULT_SCANTE_PULLID);
    defaultConfigObject.put(
        SEConnectorConsts.CONNECTOR_CONFIG_SCANTE_URL_KEY,
        SEConnectorConsts.CONNECTOR_CONFIG_DEFAULT_SCANTE_URL_KEY);
    defaultConfigObject.put(
        SEConnectorConsts.CONNECTOR_CONFIG_SCANTE_DEST_KEY,
        SEConnectorConsts.CONNECTOR_CONFIG_DEFAULT_SCANTE_DEST);
    defaultConfigObject.put(
        SEConnectorConsts.CONNECTOR_CONFIG_SCANTE_TOKEN_KEY,
        SEConnectorConsts.CONNECTOR_CONFIG_DEFAULT_SCANTE_TOKEN);
    defaultConfigObject.put(
        SEConnectorConsts.CONNECTOR_CONFIG_SCANTE_APPID_KEY,
        SEConnectorConsts.CONNECTOR_CONFIG_DEFAULT_SCANTE_APPID);
    return defaultConfigObject;
  }
}
