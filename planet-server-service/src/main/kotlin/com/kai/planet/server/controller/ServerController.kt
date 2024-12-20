package com.kai.planet.server.controller

import cn.dev33.satoken.annotation.SaIgnore
import com.kai.planet.common.domain.dto.server.ServerDTO
import com.kai.planet.common.domain.dto.server.ServerStateDTO
import com.kai.planet.common.domain.request.server.AddServerRequest
import com.kai.planet.common.domain.request.server.GetServerListRequest
import com.kai.planet.common.domain.request.server.GetServerStateRequest
import com.kai.planet.common.domain.response.R
import com.kai.planet.server.service.ServerService
import org.springframework.web.bind.annotation.*


/**
 *
 * @since 2024/11/10 18:49
 * @author 29002
 * @version 1.0.0
 */



@RestController
@RequestMapping("/server")
class ServerController(
    private val serverService: ServerService
) {


    @SaIgnore
    @PostMapping("/get-server-list")
    fun getServerList(@RequestBody request: GetServerListRequest): List<ServerDTO> {
        return serverService.getServerList(request)
    }

    @SaIgnore
    @PostMapping("/get-server-state")
    fun getServerState(@RequestBody request: GetServerStateRequest): ServerStateDTO {
        return serverService.getServerState(request)
    }

    @SaIgnore
    @PostMapping("/set-server-state")
    fun test(@RequestBody request: ServerStateDTO, @RequestParam("id") id: Long, @RequestParam("host") host: String): R<Void> {
        serverService.setServerState(request, id,host)
        return R.ok()
    }

    @SaIgnore
    @PostMapping("/add-server")
    fun addServer(@RequestBody request: AddServerRequest): R<Void> {
        serverService.addServer(request)
        return R.ok()
    }
}
