# UserApiServiceApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**cambiarContrasea**](UserApiServiceApi.md#cambiarContrasea) | **PUT** /usuario | Cambiar contraseña de usuarios
[**consultarUsuario**](UserApiServiceApi.md#consultarUsuario) | **GET** /usuario/{id} | Consulta de usuarios
[**crearUsuario**](UserApiServiceApi.md#crearUsuario) | **POST** /usuario | Crear usuario
[**loginUsuario**](UserApiServiceApi.md#loginUsuario) | **GET** /usuario | Consulta de usuarios

<a name="cambiarContrasea"></a>
# **cambiarContrasea**
> cambiarContrasea(body)

Cambiar contraseña de usuarios

Cambiar contraseña un usuario a partir de un Id y una password antigua y otra nueva

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApiServiceApi;


UserApiServiceApi apiInstance = new UserApiServiceApi();
ChangePasswordRequest body = new ChangePasswordRequest(); // ChangePasswordRequest | 
try {
    apiInstance.cambiarContrasea(body);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApiServiceApi#cambiarContrasea");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**ChangePasswordRequest**](ChangePasswordRequest.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="consultarUsuario"></a>
# **consultarUsuario**
> User consultarUsuario(id)

Consulta de usuarios

Consultar un usuario a partir de un ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApiServiceApi;


UserApiServiceApi apiInstance = new UserApiServiceApi();
Object id = null; // Object | 
try {
    User result = apiInstance.consultarUsuario(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApiServiceApi#consultarUsuario");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | [**Object**](.md)|  |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="crearUsuario"></a>
# **crearUsuario**
> User crearUsuario(body)

Crear usuario

Crear un usuario

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApiServiceApi;


UserApiServiceApi apiInstance = new UserApiServiceApi();
CreateUserRequest body = new CreateUserRequest(); // CreateUserRequest | 
try {
    User result = apiInstance.crearUsuario(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApiServiceApi#crearUsuario");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**CreateUserRequest**](CreateUserRequest.md)|  |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="loginUsuario"></a>
# **loginUsuario**
> User loginUsuario(login, password)

Consulta de usuarios

Consultar un usuario a partir de un login y password

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.UserApiServiceApi;


UserApiServiceApi apiInstance = new UserApiServiceApi();
Object login = null; // Object | 
Object password = null; // Object | 
try {
    User result = apiInstance.loginUsuario(login, password);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UserApiServiceApi#loginUsuario");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **login** | [**Object**](.md)|  |
 **password** | [**Object**](.md)|  |

### Return type

[**User**](User.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

