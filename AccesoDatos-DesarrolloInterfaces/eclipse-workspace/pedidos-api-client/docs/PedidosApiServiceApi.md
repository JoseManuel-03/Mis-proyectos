# PedidosApiServiceApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**aadirDetalles**](PedidosApiServiceApi.md#aadirDetalles) | **PUT** /pedido |  |
| [**consultarPedido**](PedidosApiServiceApi.md#consultarPedido) | **GET** /pedido/{id} |  |
| [**consultarPedidoFechas**](PedidosApiServiceApi.md#consultarPedidoFechas) | **GET** /pedido/fechas |  |
| [**consultarPedidosCliente**](PedidosApiServiceApi.md#consultarPedidosCliente) | **GET** /pedido |  |
| [**crearPedido**](PedidosApiServiceApi.md#crearPedido) | **POST** /pedido |  |


<a id="aadirDetalles"></a>
# **aadirDetalles**
> Pedido aadirDetalles(id, detalle)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PedidosApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PedidosApiServiceApi apiInstance = new PedidosApiServiceApi(defaultClient);
    String id = "id_example"; // String | 
    PedidoDetalle detalle = new PedidoDetalle(); // PedidoDetalle | 
    try {
      Pedido result = apiInstance.aadirDetalles(id, detalle);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PedidosApiServiceApi#aadirDetalles");
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
| **detalle** | [**PedidoDetalle**](.md)|  | |

### Return type

[**Pedido**](Pedido.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="consultarPedido"></a>
# **consultarPedido**
> Pedido consultarPedido(id)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PedidosApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PedidosApiServiceApi apiInstance = new PedidosApiServiceApi(defaultClient);
    String id = "id_example"; // String | 
    try {
      Pedido result = apiInstance.consultarPedido(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PedidosApiServiceApi#consultarPedido");
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

[**Pedido**](Pedido.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="consultarPedidoFechas"></a>
# **consultarPedidoFechas**
> List&lt;Pedido&gt; consultarPedidoFechas(desde, hasta)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PedidosApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PedidosApiServiceApi apiInstance = new PedidosApiServiceApi(defaultClient);
    LocalDate desde = LocalDate.now(); // LocalDate | 
    LocalDate hasta = LocalDate.now(); // LocalDate | 
    try {
      List<Pedido> result = apiInstance.consultarPedidoFechas(desde, hasta);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PedidosApiServiceApi#consultarPedidoFechas");
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
| **desde** | **LocalDate**|  | |
| **hasta** | **LocalDate**|  | |

### Return type

[**List&lt;Pedido&gt;**](Pedido.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="consultarPedidosCliente"></a>
# **consultarPedidosCliente**
> List&lt;Pedido&gt; consultarPedidosCliente(dni)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PedidosApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PedidosApiServiceApi apiInstance = new PedidosApiServiceApi(defaultClient);
    String dni = "dni_example"; // String | 
    try {
      List<Pedido> result = apiInstance.consultarPedidosCliente(dni);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PedidosApiServiceApi#consultarPedidosCliente");
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

[**List&lt;Pedido&gt;**](Pedido.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

<a id="crearPedido"></a>
# **crearPedido**
> String crearPedido(pedido)



### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.PedidosApiServiceApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080");

    PedidosApiServiceApi apiInstance = new PedidosApiServiceApi(defaultClient);
    Pedido pedido = new Pedido(); // Pedido | 
    try {
      String result = apiInstance.crearPedido(pedido);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling PedidosApiServiceApi#crearPedido");
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
| **pedido** | [**Pedido**](Pedido.md)|  | |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

