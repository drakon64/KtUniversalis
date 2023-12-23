#!/usr/bin/env python3

import json

import requests

universalis_datacenters = json.loads(
    requests.get("https://universalis.app/api/v2/data-centers").content
)
universalis_worlds: list[dict] = json.loads(
    requests.get("https://universalis.app/api/v2/worlds").content
)

for datacenter in universalis_datacenters:
    world_ids = list()

    for world in datacenter["worlds"]:
        for universalis_world_id in universalis_worlds:
            if universalis_world_id["id"] == world:
                world_ids.append(f'World.{universalis_world_id["name"]}')

    print(
        f'{datacenter["name"]}(Region.{datacenter["region"]}, listOf({", ".join(world_ids)})),'
    )
