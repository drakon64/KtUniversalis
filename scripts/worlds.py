#!/usr/bin/env python3

import json

import requests

universalis_worlds = json.loads(
    requests.get("https://universalis.app/api/v2/worlds").content
)
universalis_datacenters = json.loads(
    requests.get("https://universalis.app/api/v2/data-centers").content
)

for world in universalis_worlds:
    world_id = world["id"]

    for universalis_datacenter in universalis_datacenters:
        if world_id in universalis_datacenter["worlds"]:
            datacenter = universalis_datacenter["name"]

    print(f'{world["name"]}({world_id}, DataCenter.{datacenter}),')

for world in universalis_worlds:
    print(f'{world["name"]}.id to {world["name"]},')
