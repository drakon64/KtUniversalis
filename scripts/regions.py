#!/usr/bin/env python3

import json

import requests

datacenters = json.loads(
    requests.get("https://universalis.app/api/v2/data-centers").content
)
regions = {
    "Japan": [],
    "North-America": [],
    "Europe": [],
    "Oceania": [],
    "中国": [],
    "한국": [],
}

for datacenter in datacenters:
    regions[datacenter["region"]].append(datacenter["name"])

for region in regions.keys():
    datacenters = list()

    for datacenter in regions[region]:
        datacenters.append(f"DataCenter.{datacenter}")

    print(f'{region}(listOf({", ".join(datacenters)})),')
