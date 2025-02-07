# ClienteApiServiceApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**actualizarClient**](ClienteApiServiceApi.md#actualizarClient) | **PUT** /cliente |  |
| [**consularPorId**](ClienteApiServiceApi.md#consularPorId) | **GET** /cliente/{id} |  |
| [**consultarPorDni**](ClienteApiServiceApi.md#consultarPorDni) | **GET** /cliente |  |
| [**crearClient**](ClienteApiServiceApi.md#crearClient) | **POST** /cliente |  |


<a id="actualizarClient"></a>
# **actualizarClient**
> Cliente actualizarClient(cliente)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClienteApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ClienteApiServiceApi apiInstance = new ClienteApiServiceApi(defaultClient);
    Cliente cliente = new Cliente(); // Cliente | 
    try {
      Cliente result = apiInstance.actualizarClient(cliente);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClienteApiServiceApi#actualizarClient");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **cliente** | [**Cliente**](Cliente.md)|  | |

### Return type

[**Cliente**](Cliente.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="consularPorId"></a>
# **consularPorId**
> Cliente consularPorId(id)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClienteApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ClienteApiServiceApi apiInstance = new ClienteApiServiceApi(defaultClient);
    String id = "id_example"; // String | 
    try {
      Cliente result = apiInstance.consularPorId(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClienteApiServiceApi#consularPorId");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**|  | |

### Return type

[**Cliente**](Cliente.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="consultarPorDni"></a>
# **consultarPorDni**
> Cliente consultarPorDni(dni)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClienteApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ClienteApiServiceApi apiInstance = new ClienteApiServiceApi(defaultClient);
    String dni = "dni_example"; // String | 
    try {
      Cliente result = apiInstance.consultarPorDni(dni);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClienteApiServiceApi#consultarPorDni");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **dni** | **String**|  | |

### Return type

[**Cliente**](Cliente.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="crearClient"></a>
# **crearClient**
> Cliente crearClient(cliente)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.ClienteApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    ClienteApiServiceApi apiInstance = new ClienteApiServiceApi(defaultClient);
    Cliente cliente = new Cliente(); // Cliente | 
    try {
      Cliente result = apiInstance.crearClient(cliente);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ClienteApiServiceApi#crearClient");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **cliente** | [**Cliente**](Cliente.md)|  | |

### Return type

[**Cliente**](Cliente.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

