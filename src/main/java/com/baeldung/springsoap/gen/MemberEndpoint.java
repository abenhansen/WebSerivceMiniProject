package com.baeldung.springsoap.gen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class MemberEndpoint {

    private static final String NAMESPACE_URI = "http://www.baeldung.com/springsoap/gen";

    private MemberRepository memberRepository;

    @Autowired
    public MemberEndpoint(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMemberRequest")
    @ResponsePayload
    public GetMemberResponse getMember(@RequestPayload GetMemberRequest request) {
        GetMemberResponse response = new GetMemberResponse();
        response.setMember(memberRepository.findMember(request.getEmail()));
        return response;
    }


}
