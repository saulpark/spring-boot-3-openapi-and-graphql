package com.template.springboot.backend.inbound.client.grpc;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class ClientGrpcController extends ClientServiceGrpc.ClientServiceImplBase {

    @Override
    public void createClient (ClientRequest request,
                              StreamObserver<ClientResponse> responseObserver) {

        ClientResponse response = ClientResponse.newBuilder()
                .setName("grpc")
                .setLastName("test")
                .setCreateAt("2018-03-06T00:00")
                .setEmail("email@grpc.com")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
